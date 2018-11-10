package com.quicksilver.getmydrivercard.views.step2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationImages;
import com.quicksilver.getmydrivercard.models.ApplicationReason;
import com.quicksilver.getmydrivercard.models.DrivingLicense;
import com.quicksilver.getmydrivercard.models.IdentityCard;
import com.quicksilver.getmydrivercard.models.Person;
import com.quicksilver.getmydrivercard.models.User;

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
public class NewCardFragment extends Fragment implements Step2Contracts.View {
    @BindView(R.id.et_identity_number)
    EditText mIdentityNumber;

    @BindView(R.id.et_first_name)
    EditText mFirstName;

    @BindView(R.id.et_fathers_name)
    EditText mFathersName;

    @BindView(R.id.et_last_name)
    EditText mLastName;

    @BindView(R.id.et_phone_number)
    EditText mPhoneNumber;
    private Step2Contracts.Presenter mPresenter;
    private Step2Contracts.Navigator mNavigator;
    private User mUser;
    private String mReason;

    @Inject
    public NewCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_card, container, false);

        ButterKnife.bind(this, view);

        Intent intent = getActivity().getIntent();
        mUser = (User)intent.getSerializableExtra(Constants.USER);
        mReason = intent.getStringExtra(Constants.REASON);

        return view;
    }

    @OnClick(R.id.btn_next)
    public void onClick(View view) {
        String identityNumberStr = mIdentityNumber.getText().toString();
        String firstName = mFirstName.getText().toString();
        String fathersName = mFathersName.getText().toString();
        String lastName = mLastName.getText().toString();
        String phoneNumberStr = mPhoneNumber.getText().toString();

        boolean isValid = true;

        if(identityNumberStr.length() != 10) {
            mIdentityNumber.setError(Constants.IDENTITY_NUMBER_ERROR);
            Toast.makeText(getContext(), Constants.FIELDS_ERROR, Toast.LENGTH_SHORT).show();
            return;
        }

        if(firstName.length() < 2 || firstName.length() > 20) {
            mFirstName.setError(Constants.FIRST_NAME_ERROR);
            isValid = false;
        }

        if(fathersName.length() < 2 || fathersName.length() > 30) {
            mFathersName.setError(Constants.FATHERS_NAME_ERROR);
            isValid = false;
        }

        if(lastName.length() < 2 || lastName.length() > 20) {
            mLastName.setError(Constants.LAST_NAME_ERROR);
            isValid = false;
        }

        if(phoneNumberStr.length() != 10) {
            mPhoneNumber.setError(Constants.PHONE_NUMBER_ERROR);
            isValid = false;
        }

        if (!isValid) {
            Toast.makeText(getContext(), Constants.FIELDS_ERROR, Toast.LENGTH_SHORT).show();
            return;
        }

        Long identityNumber = Long.parseLong(identityNumberStr);
        Long phoneNumber = Long.parseLong(phoneNumberStr);

        Application application = new Application();
        Person person = new Person();
        IdentityCard identityCard = new IdentityCard();
        DrivingLicense drivingLicense = new DrivingLicense();
        ApplicationImages applicationImages = new ApplicationImages();
        application.setApplicationImages(applicationImages);
        identityCard.setPersonalNumber(identityNumber);

        identityCard.setFirstName(firstName);

        identityCard.setFathersName(fathersName);

        identityCard.setLastName(lastName);

        person.setIdentityCard(identityCard);
        person.setPhoneNumber(phoneNumber);
        person.setDrivingLicense(drivingLicense);
        person.setEmail(mUser.getEmail());

        DateFormat dateFormat = new SimpleDateFormat("dd\\MM\\YYYY");
        String year = mIdentityNumber.getText().toString().substring(0, 2);
        String month = mIdentityNumber.getText().toString().substring(2, 4);
        String day = mIdentityNumber.getText().toString().substring(4, 6);
        String dateStr = day + "\\" + month + "\\" + year;

        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            Toast.makeText(getContext(), Constants.DATE_ERROR, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return;
        }

        application.setPerson(person);

        if(mReason.equals(Constants.NEW_CARD)) {
            application.setApplicationReason(ApplicationReason.NEW);
        } else if(mReason.equals(Constants.WITHDRAWN_CARD)) {
            application.setApplicationReason(ApplicationReason.WITHDRAWN);
        }

        mNavigator.navigateToNextStep(application);
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

    }

    @Override
    public void showError(Throwable error) {

    }
}
