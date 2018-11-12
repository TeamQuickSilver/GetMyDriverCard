package com.quicksilver.getmydrivercard.views.preview;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreviewFragment extends Fragment implements PreviewContracts.View{

    private PreviewContracts.Navigator mNavigator;
    private PreviewContracts.Presenter mPresenter;

    @BindView(R.id.iv_photo)
    ImageView mPhoto;

    @BindView(R.id.iv_signature)
    ImageView mSignatureImage;

    @BindView(R.id.tv_identity_number)
    TextView mIdentityNumber;

    @BindView(R.id.tv_first_name)
    TextView mFirstName;

    @BindView(R.id.tv_fathers_name)
    TextView mFatherName;

    @BindView(R.id.tv_last_name)
    TextView mLastName;

    @BindView(R.id.tv_district)
    TextView mDistrict;

    @BindView(R.id.tv_city)
    TextView mCity;

    @BindView(R.id.tv_address)
    TextView mAddress;

    @BindView(R.id.tv_phone_number)
    TextView mPhoneNumber;

    @BindView(R.id.tv_email)
    TextView mEmail;

    @BindView(R.id.tv_status)
    TextView mStatus;

    @BindView(R.id.tv_reason)
    TextView mReason;

    @BindView(R.id.iv_identity_card_photo)
    ImageView mIdentityCardPhoto;

    @BindView(R.id.iv_driving_license_photo)
    ImageView mDrivingLicensePhoto;


    @BindView(R.id.btn_submit)
    Button mSubmitButton;
    private User mUser;
    private Application mApplication;

    @Inject
    public PreviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_preview, container, false);

        ButterKnife.bind(this, view);
        Intent intent = getActivity().getIntent();
        mUser = (User)intent.getSerializableExtra(Constants.USER);
        mApplication = (Application)intent.getSerializableExtra(Constants.APPLICATION);

        byte[] personImageBytes = mApplication.getApplicationImages().getPersonImage();
        byte[] signatureImageBytes = mApplication.getApplicationImages().getSignatureImage();
        Bitmap bitmapPersonImage = BitmapFactory.decodeByteArray(personImageBytes, 0, personImageBytes.length);
        Bitmap bitmapSignature = BitmapFactory.decodeByteArray(signatureImageBytes, 0, signatureImageBytes.length);
        mPhoto.setImageBitmap(bitmapPersonImage);
        mSignatureImage.setImageBitmap(bitmapSignature);
        mIdentityNumber.setText(mApplication.getPerson().getIdentityCard().getPersonalNumber() + "");
        mFirstName.setText(mApplication.getPerson().getIdentityCard().getFirstName() + "");
        mFatherName.setText(mApplication.getPerson().getIdentityCard().getFathersName() + "");
        mLastName.setText(mApplication.getPerson().getIdentityCard().getLastName() + "");
        mDistrict.setText(mApplication.getPerson().getIdentityCard().getAddress().getDistrict() + "");
        mCity.setText(mApplication.getPerson().getIdentityCard().getAddress().getCity() + "");
        mAddress.setText(mApplication.getPerson().getIdentityCard().getAddress().getAddress() + "");
        mPhoneNumber.setText(mApplication.getPerson().getPhoneNumber() + "");
        mEmail.setText(mApplication.getPerson().getEmail() + "");
        mReason.setText(mApplication.getApplicationReason() + "");
        mStatus.setText(mApplication.getApplicationStatus() + "");
        byte[] identityCardBytes = mApplication.getApplicationImages().getIdentityCardImage();
        Bitmap bitmapIdentityCard = BitmapFactory.decodeByteArray(identityCardBytes, 0, identityCardBytes.length);
        mIdentityCardPhoto.setImageBitmap(bitmapIdentityCard);
        byte[] drivingLicenseBytes = mApplication.getApplicationImages().getDrivingLicenseImage();
        Bitmap bitmapDrivingLicense = BitmapFactory.decodeByteArray(drivingLicenseBytes, 0, drivingLicenseBytes.length);
        mDrivingLicensePhoto.setImageBitmap(bitmapDrivingLicense);

        return view;
    }

    @Override
    public void setPresenter(PreviewContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(PreviewContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void showSuccessfulToast() {
//        Toast.makeText(getContext(), Constants.SUCCESSFUL_SUBMIT, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @OnClick(R.id.btn_submit)
    public void onClick(View view) {
        mPresenter.submit(mApplication);
        mNavigator.navigateTo(mApplication);
    }
}
