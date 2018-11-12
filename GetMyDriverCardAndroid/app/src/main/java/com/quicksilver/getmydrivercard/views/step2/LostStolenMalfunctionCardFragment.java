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
import com.quicksilver.getmydrivercard.models.ApplicationReason;

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

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    private void arrangeViews(String reason) {
        switch (reason) {
            case Constants.LOST_CARD:

                break;
            case Constants.STOLEN_CARD:

                break;
            case Constants.MALFUNCTION_BROKEN_CARD:

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
                        month++;
                        mChosenDate.setText(year + "-" + month + "-" + dayOfMonth);
                        mChosenDate.setVisibility(View.VISIBLE);
                    }
                }, year, month, day);
                mDatePickerDialog.show();
                break;
            case R.id.btn_next:
                String identityNumberStr = mIdentityNumber.getText().toString();

                if(identityNumberStr.length() != 10) {
                    mIdentityNumber.setError(Constants.IDENTITY_NUMBER_ERROR);
                    Toast.makeText(getContext(), Constants.FIELDS_ERROR, Toast.LENGTH_SHORT).show();
                    return;
                }

                Long identityNumber = Long.parseLong(identityNumberStr);
                mPresenter.loadApplication(identityNumber);
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
        boolean isValid = true;
        String place = mPlaceEditText.getText().toString();

        if(place.length() < 5 || place.length() >= 30) {
            mPlaceEditText.setError(Constants.PLACE_ERROR);
            isValid = false;
        }

        if(!isValid) {
            Toast.makeText(getContext(), Constants.FIELDS_ERROR, Toast.LENGTH_SHORT).show();
            return;
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(mChosenDate.getText().toString());
        } catch (ParseException e) {
            Toast.makeText(getContext(), Constants.DATE_ERROR, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return;
        }

        mApplication.setApplicationReason(Constants.LOST);
        mApplication.setPlaceLost(place);
        mApplication.setDateLost(date);
        mNavigator.navigateToNextStep(mApplication);
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}




