package com.quicksilver.getmydrivercard.views.step2;


import android.app.DatePickerDialog;
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
import com.quicksilver.getmydrivercard.models.Address;
import com.quicksilver.getmydrivercard.models.Application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewCardFragmentDocuments extends Fragment implements Step2Contracts.View {
    @BindView(R.id.et_district)
    EditText mDistrict;

    @BindView(R.id.et_city)
    EditText mCity;

    @BindView(R.id.et_address)
    EditText mAddress;

    @BindView(R.id.et_identity_card_number)
    EditText mIdentityCardNumber;

    @BindView(R.id.et_issued_by)
    EditText mIssuedBy;

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

    @Inject
    public NewCardFragmentDocuments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_card_fragment_documents, container, false);

        ButterKnife.bind(this, view);
        mApplication = (Application) getActivity().getIntent().getSerializableExtra(Constants.APPLICATION);

        return view;
    }


    @OnClick({R.id.btn_pick_date, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pick_date:
                mCalendar = Calendar.getInstance();
                int day = mCalendar.get(Calendar.DAY_OF_MONTH);
                int month = mCalendar.get(Calendar.MONTH);
                int year = mCalendar.get(Calendar.YEAR);

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
                String district = mDistrict.getText().toString();
                String city = mCity.getText().toString();
                String address = mAddress.getText().toString();
                String identityCardNumberStr = mIdentityCardNumber.getText().toString();
                String issuedBy = mIssuedBy.getText().toString();

                boolean isValid = true;

                if(district.length() < 3 || district.length() >= 20) {
                    mDistrict.setError(Constants.DISTRICT_ERROR);
                    isValid = false;
                }

                if(city.length() < 3 || city.length() >= 20) {
                    mCity.setError(Constants.CITY_ERROR);
                    isValid = false;
                }

                if(address.length() < 5 || address.length() >= 30) {
                    mAddress.setError(Constants.ADDRESS_ERROR);
                    isValid = false;
                }

                if(identityCardNumberStr.length() != 9) {
                    mIdentityCardNumber.setError(Constants.IDENTITY_CARD_NUMBER_ERROR);
                    isValid = false;
                }

                if(issuedBy.length() < 3 || issuedBy.length() >= 20) {
                    mIssuedBy.setError(Constants.ISSUED_BY_ERROR);
                    isValid = false;
                }

                if(!isValid) {
                    Toast.makeText(getContext(), Constants.FIELDS_ERROR, Toast.LENGTH_SHORT).show();
                    return;
                }

                Address fullAddress = new Address(district, city, address);
                Long identityCardNumber = Long.parseLong(identityCardNumberStr);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                String dayOfBirth = identityCardNumberStr.substring(4, 6);
//                String monthOfBirth = identityCardNumberStr.substring(2, 4);
//                String yearOfBirth = identityCardNumberStr.substring(0, 2);
//                Date dateOfBirth = null;
                Date date = null;
                try {
                    date = dateFormat.parse(mChosenDate.getText().toString());
//                    dateOfBirth = dateFormat.parse(dayOfBirth + monthOfBirth + yearOfBirth);
                } catch (ParseException e) {
                    Toast.makeText(getContext(), Constants.DATE_ERROR, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                    return;
                }

                mApplication.getPerson().getIdentityCard().setIdentityCardNumber(identityCardNumber);
                mApplication.getPerson().getIdentityCard().setAddress(fullAddress);
                mApplication.getPerson().getIdentityCard().setIssuedBy(issuedBy);
                mApplication.getPerson().getIdentityCard().setIssuedOn(date);
//                mApplication.getPerson().getIdentityCard().setDateOfBirth(dateOfBirth);
                mNavigator.navigateToNextStep(mApplication);
                break;
        }
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
}
