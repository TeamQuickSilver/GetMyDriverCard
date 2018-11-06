package com.quicksilver.getmydrivercard.views.step2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Address;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationReason;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeCardFragment extends Fragment implements Step2Contracts.View {
    @BindView(R.id.relative_layout)
    RelativeLayout mRelativeLayout;

    @BindView(R.id.tv_identity_number)
    TextView mIdentityNumberTextView;

    @BindView(R.id.tv_district)
    TextView mDistrictTextView;

    @BindView(R.id.tv_city)
    TextView mCityTextView;

    @BindView(R.id.tv_address)
    TextView mAddressTextView;

    @BindView(R.id.tv_first_name)
    TextView mFirstNameTextView;

    @BindView(R.id.tv_fathers_name)
    TextView mFathersNameTextView;

    @BindView(R.id.tv_last_name)
    TextView mLastNameTextView;

    @BindView(R.id.tv_driving_license)
    TextView mDrivingLicenseTextView;

    @BindView(R.id.et_driving_license)
    EditText mDrivingLicenseEditText;

    @BindView(R.id.et_district)
    EditText mDistrictEditText;

    @BindView(R.id.et_city)
    EditText mCityEditText;

    @BindView(R.id.et_address)
    EditText mAddressEditText;

    @BindView(R.id.et_first_name)
    EditText mFirstNameEditText;

    @BindView(R.id.et_fathers_name)
    EditText mFathersNameEditText;

    @BindView(R.id.et_last_name)
    EditText mLastNameEditText;

    @BindView(R.id.et_identity_number)
    EditText mIdentityNumberEditText;


    @BindView(R.id.btn_next)
    Button mNextButton;
    private String mReason;
    private Step2Contracts.Navigator mNavigator;
    private Application mApplication;
    private Step2Contracts.Presenter mPresenter;

    @Inject
    public ChangeCardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_card, container, false);
        ButterKnife.bind(this, view);
        mReason = Objects.requireNonNull(getActivity()).getIntent().getStringExtra(Constants.INTENT_REASON);

        arrangeViews(mReason);
        return view;
    }

    private void arrangeViews(String reason) {
        switch (reason) {
            case Constants.ADDRESS_CHANGE:
                showAddressChangeView();
                break;
            case Constants.NAME_CHANGE:
                showNameChangeView();
                break;
            case Constants.DRIVING_LICENSE_CHANGE:
                showDrivingLicenseChangeView();
                break;
        }
    }


    private void showAddressChangeView() {
        mDistrictTextView.setVisibility(View.VISIBLE);
        mDistrictEditText.setVisibility(View.VISIBLE);
        mCityTextView.setVisibility(View.VISIBLE);
        mCityEditText.setVisibility(View.VISIBLE);
        mAddressTextView.setVisibility(View.VISIBLE);
        mAddressEditText.setVisibility(View.VISIBLE);

        addParamsToRelativeLayout(R.id.et_address);
    }

    private void showNameChangeView() {
        mFirstNameTextView.setVisibility(View.VISIBLE);
        mFirstNameEditText.setVisibility(View.VISIBLE);
        mFathersNameTextView.setVisibility(View.VISIBLE);
        mFathersNameEditText.setVisibility(View.VISIBLE);
        mLastNameTextView.setVisibility(View.VISIBLE);
        mLastNameEditText.setVisibility(View.VISIBLE);

        addParamsToRelativeLayout(R.id.et_last_name);
    }

    private void showDrivingLicenseChangeView() {
        mDrivingLicenseTextView.setVisibility(View.VISIBLE);
        mDrivingLicenseEditText.setVisibility(View.VISIBLE);

        addParamsToRelativeLayout(R.id.et_driving_license);
    }

    private void addParamsToRelativeLayout(int id) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.BELOW, id);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        mNextButton.setText(R.string.next);
        mNextButton.setLayoutParams(layoutParams);
    }

    @OnClick(R.id.btn_next)
    public void onClick(View view) {
        String identityNumberStr = mIdentityNumberEditText.getText().toString();
        boolean isValid = true;

        if (identityNumberStr.length() != 10) {
            mIdentityNumberEditText.setError(Constants.IDENTITY_NUMBER_ERROR);
            isValid = false;
        }

        Long identityNumber = Long.parseLong(identityNumberStr);
        mPresenter.loadApplication(identityNumber);
        switch (mReason) {
            case Constants.ADDRESS_CHANGE:
                String district = mDistrictEditText.getText().toString();
                String city = mCityEditText.getText().toString();
                String address = mAddressEditText.getText().toString();

                if (district.length() < 3 || district.length() >= 20) {
                    mDistrictEditText.setError(Constants.DISTRICT_ERROR);
                    isValid = false;
                }

                if (city.length() < 3 || city.length() >= 20) {
                    mCityEditText.setError(Constants.CITY_ERROR);
                    isValid = false;
                }

                if (address.length() < 5 || address.length() >= 30) {
                    mAddressEditText.setError(Constants.ADDRESS_ERROR);
                    isValid = false;
                }

                if (!isValid) {
                    Toast.makeText(getContext(), Constants.FIELDS_ERROR, Toast.LENGTH_SHORT).show();
                    return;
                }

                Address fullAddress = new Address(district, city, address);
                mApplication.setApplicationReason(ApplicationReason.ADDRESS_CHANGE);
                mApplication.getPerson().getIdentityCard().setAddress(fullAddress);
                break;
            case Constants.NAME_CHANGE:
                String firstName = mFirstNameEditText.getText().toString();
                String fathersName = mFathersNameEditText.getText().toString();
                String lastName = mLastNameEditText.getText().toString();

                if (firstName.length() < 2 || firstName.length() > 20) {
                    mFirstNameEditText.setError(Constants.FIRST_NAME_ERROR);
                    isValid = false;
                }

                if (fathersName.length() < 2 || fathersName.length() > 30) {
                    mFathersNameEditText.setError(Constants.FATHERS_NAME_ERROR);
                    isValid = false;
                }

                if (lastName.length() < 2 || lastName.length() > 20) {
                    mLastNameEditText.setError(Constants.LAST_NAME_ERROR);
                    isValid = false;
                }

                if (!isValid) {
                    Toast.makeText(getContext(), Constants.FIELDS_ERROR, Toast.LENGTH_SHORT).show();
                    return;
                }

                mApplication.setApplicationReason(ApplicationReason.NAME_CHANGE);
                mApplication.getPerson().getIdentityCard().setFirstName(firstName);
                mApplication.getPerson().getIdentityCard().setFathersName(fathersName);
                mApplication.getPerson().getIdentityCard().setLastName(lastName);
                break;
            case Constants.PHOTO_CHANGE:
                mApplication.setApplicationReason(ApplicationReason.PHOTO_CHANGE);
                break;
            case Constants.DRIVING_LICENSE_CHANGE:
                mApplication.setApplicationReason(ApplicationReason.DRIVING_LICENSE_CHANGE);
                break;
        }

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
