package com.quicksilver.getmydrivercard.views.step2;


import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LostStolenMalfunctionCardFragment extends Fragment implements Step2Contracts.View {
    @BindView(R.id.et_identity_number)
    EditText mIdentityNumber;

    @BindView(R.id.et_place)
    EditText mPlaceEditText;

    @BindView(R.id.tv_date)
    TextView mDate;

    @BindView(R.id.btn_pick_date)
    Button mButtonPickDate;

    @BindView(R.id.btn_next)
    Button mButtonNext;

    @BindView(R.id.tv_chosen_date)
    TextView mChosenDate;

    private Application mApplication;
    private Calendar mCalendar;
    private DatePickerDialog mDatePickerDialog;
    private Step2Contracts.Navigator mNavigator;
    private Step2Contracts.Presenter mPresenter;

    @Inject
    public LostStolenMalfunctionCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lost_stolen_malfunction_card, container, false);

        ButterKnife.bind(this, view);
        String reason = Objects.requireNonNull(getActivity()).getIntent().getStringExtra(Constants.INTENT_REASON);

        arrangeViews(reason);

        return view;
    }

    private void arrangeViews(String reason) {
        switch (reason) {
            case Constants.LOST_TEXT:

                break;
            case Constants.STOLEN_TEXT:

                break;
            case Constants.MALFUNCTION_BROKEN_TEXT:

                break;
        }
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
                Long identityNumber = Long.parseLong(mIdentityNumber.getText().toString());
                mPresenter.loadApplication(identityNumber);

                String place = mPlaceEditText.getText().toString();
                DateFormat dateFormat = new SimpleDateFormat("dd\\MM\\YYYY");
                Date date = null;
                try {
                    date = dateFormat.parse(mChosenDate.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                mApplication.setPlaceLost(place);
                mApplication.setDateLost(date);
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




