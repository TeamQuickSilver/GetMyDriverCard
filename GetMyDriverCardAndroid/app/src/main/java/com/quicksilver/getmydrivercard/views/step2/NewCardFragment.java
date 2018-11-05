package com.quicksilver.getmydrivercard.views.step2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.DrivingLicense;
import com.quicksilver.getmydrivercard.models.IdentityCard;
import com.quicksilver.getmydrivercard.models.Person;

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

        return view;
    }

    @OnClick(R.id.btn_next)
    public void onClick(View view) {
        Long identityNumber = Long.parseLong(mIdentityNumber.getText().toString());
        String firstName = mFirstName.getText().toString();
        String fathersName = mFathersName.getText().toString();
        String lastName = mLastName.getText().toString();
        Long phoneNumber = Long.parseLong(mPhoneNumber.getText().toString());

        Application application = new Application();
        Person person = new Person();
        IdentityCard identityCard = new IdentityCard();
        DrivingLicense drivingLicense = new DrivingLicense();
        identityCard.setPersonalNumber(identityNumber);
        identityCard.setFirstName(firstName);
        identityCard.setFathersName(fathersName);
        identityCard.setLastName(lastName);
        person.setIdentityCard(identityCard);
        person.setPhoneNumber(phoneNumber);
        person.setDrivingLicense(drivingLicense);
        // person.setEmail(email);
        application.setPerson(person);

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
