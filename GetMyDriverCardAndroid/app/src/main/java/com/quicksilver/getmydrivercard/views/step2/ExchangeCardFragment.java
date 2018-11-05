package com.quicksilver.getmydrivercard.views.step2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationReason;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExchangeCardFragment extends Fragment implements Step2Contracts.View{
    @BindView(R.id.et_identity_number)
    EditText mIdentityNumber;

    @BindView(R.id.et_country)
    EditText mCountry;

    @BindView(R.id.et_card_number)
    EditText mCardNumber;

    @BindView(R.id.et_country_driving_license)
    EditText mCountryDrivingLicense;

    @BindView(R.id.et_driving_license_number)
    EditText mDrivingLicenseNumber;

    @BindView(R.id.btn_next)
    Button mNextButton;
    private Step2Contracts.Navigator mNavigator;
    private Application mApplication;
    private Step2Contracts.Presenter mPresenter;

    @Inject
    public ExchangeCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exchange_card, container, false);

        ButterKnife.bind(this, view);
        mCountry.setSelection(0);

        return view;
    }

    @OnClick({R.id.btn_next})
    public void onClick(View view) {
        Long identityNumber = Long.parseLong(mIdentityNumber.getText().toString());
        mPresenter.loadApplication(identityNumber);

        String countryWhichIssuedPreviousCard = mCountry.getText().toString();
        Long tachographCardNumber = Long.parseLong(mCardNumber.getText().toString());
        String countryWhichIssuedDrivingLicense = mCountryDrivingLicense.getText().toString();
//        Long drivingLicenseNumber = Long.parseLong(mDrivingLicenseNumber.getText().toString());


        mApplication.setApplicationReason(ApplicationReason.EXCHANGE);
        mApplication.setCountryPreviousCard(countryWhichIssuedPreviousCard);
        mApplication.setPreviousCardNumber(tachographCardNumber);
        mApplication.setCountryDrivingLicense(countryWhichIssuedDrivingLicense);
        mNavigator.navigateToNextStep(mApplication);
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
