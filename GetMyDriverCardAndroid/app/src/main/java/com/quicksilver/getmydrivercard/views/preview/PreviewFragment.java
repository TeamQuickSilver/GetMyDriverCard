package com.quicksilver.getmydrivercard.views.preview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.quicksilver.getmydrivercard.R;

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
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @OnClick(R.id.btn_submit)
    public void onClick(View view) {

    }
}
