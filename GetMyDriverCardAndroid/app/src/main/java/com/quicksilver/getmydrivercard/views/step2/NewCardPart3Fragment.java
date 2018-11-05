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

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;

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
public class NewCardPart3Fragment extends Fragment implements Step2Contracts.View{
    @BindView(R.id.et_driving_license_number)
    EditText mDrivingLicenseNumber;

    @BindView(R.id.et_issued_by)
    EditText mIssuedBy;

    @BindView(R.id.btn_pick_date)
    Button mButtonPickDate;

    @BindView(R.id.btn_next)
    Button mButtonNext;

    @BindView(R.id.tv_chosen_date)
    TextView mChosenDate;

    @BindView(R.id.et_categories)
    EditText mCategories;

    private Application mApplication;
    private Calendar mCalendar;
    private DatePickerDialog mDatePickerDialog;
    private Step2Contracts.Navigator mNavigator;


    @Inject
    public NewCardPart3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_card_part3, container, false);

        ButterKnife.bind(this, view);
        mApplication = (Application) getActivity().getIntent().getSerializableExtra(Constants.APPLICATION);

        return view;
    }

    @Override
    public void setPresenter(Step2Contracts.Presenter presenter) {

    }

    @Override
    public void setNavigator(Step2Contracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void getApplication(Application application) {

    }

    @Override
    public void showError(Throwable error) {

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
                Long drivingLicenseNumber = Long.parseLong(mDrivingLicenseNumber.getText().toString());
                String issuedBy = mIssuedBy.getText().toString();
                String categories = mCategories.getText().toString();

                DateFormat dateFormat = new SimpleDateFormat("dd\\MM\\YYYY");
                Date date = null;
                try {
                    date = dateFormat.parse(mChosenDate.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                mApplication.getPerson().getDrivingLicense().setDrivingLicenseNumber(drivingLicenseNumber);
                mApplication.getPerson().getDrivingLicense().setIssuedBy(issuedBy);
                mApplication.getPerson().getDrivingLicense().setIssuedOn(date);
                mApplication.getPerson().getDrivingLicense().setMotorVehiclesCategories(categories);
                mNavigator.navigateToNextStep(mApplication);
                break;
        }
    }
}
