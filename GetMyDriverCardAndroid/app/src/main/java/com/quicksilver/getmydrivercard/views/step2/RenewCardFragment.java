package com.quicksilver.getmydrivercard.views.step2;


import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationReason;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RenewCardFragment extends Fragment implements Step2Contracts.View {
    @BindView(R.id.et_identity_number)
    EditText mIdentityNumber;

    @BindView(R.id.btn_pick_date)
    Button mButtonPickDate;

    @BindView(R.id.tv_chosen_date)
    TextView mChosenDate;

    @BindView(R.id.btn_next)
    Button mButtonNext;

    private Step2Contracts.Navigator mNavigator;
    private Application mApplication;
    private Calendar mCalendar;
    private DatePickerDialog mDatePickerDialog;
    private Step2Contracts.Presenter mPresenter;

    @Inject
    public RenewCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_renew_card, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.btn_pick_date, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pick_date:
                mCalendar = Calendar.getInstance();
                int day = mCalendar.get(java.util.Calendar.DAY_OF_MONTH);
                int month = mCalendar.get(java.util.Calendar.MONTH);
                int year = mCalendar.get(java.util.Calendar.YEAR);

                mDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mChosenDate.setText(dayOfMonth + "\\" + month + "\\" + year);
                        mChosenDate.setVisibility(View.VISIBLE);
                    }
                }, year, month, day);
                mDatePickerDialog.show();
                break;
            case R.id.btn_next:
                boolean isValid = true;
                String identityNumberStr = mIdentityNumber.getText().toString();

                if(identityNumberStr.length() != 10) {
                    mIdentityNumber.setError(Constants.IDENTITY_NUMBER_ERROR);
                    Toast.makeText(getContext(), Constants.IDENTITY_NUMBER_ERROR, Toast.LENGTH_SHORT).show();
                    return;
                }

                Long identityNumber = Long.parseLong(mIdentityNumber.getText().toString());
                mPresenter.loadApplication(identityNumber);

                DateFormat dateFormat = new SimpleDateFormat("dd\\MM\\YYYY");
                Date date = null;
                try {
                    date = dateFormat.parse(mChosenDate.getText().toString());
                } catch (ParseException e) {
                    Toast.makeText(getContext(), Constants.DATE_ERROR, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                    return;
                }

                mApplication.setApplicationReason(ApplicationReason.RENEW);
                mApplication.setDateOfExpire(date);
                mNavigator.navigateToNextStep(mApplication);
                break;
        }
    }

    @Override
    public void setPresenter(Step2Contracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(Step2Contracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void getApplication(Application application) {
        mApplication = application;
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
