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

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeCardFragment extends Fragment {
    @BindView(R.id.relative_layout)
    RelativeLayout mRelativeLayout;

    @BindView(R.id.tv_identity_number)
    TextView mIdentityNumberTextView;

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
        switch (mReason) {
            case Constants.ADDRESS_CHANGE:
                break;
            case Constants.NAME_CHANGE:
                String identityNumber = mIdentityNumberEditText.getText().toString();
                String firstName = mFirstNameEditText.getText().toString();
                String fathersName = mFathersNameEditText.getText().toString();
                String lastName = mLastNameEditText.getText().toString();
                break;
            case Constants.PHOTO_CHANGE:
                break;
            case Constants.DRIVING_LICENSE_CHANGE:
                break;
        }

        // Navigate to Step 3
    }
}
