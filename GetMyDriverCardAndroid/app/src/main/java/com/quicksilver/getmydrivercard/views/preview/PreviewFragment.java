package com.quicksilver.getmydrivercard.views.preview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

    @BindView(R.id.photo_container)
    ImageView mPhotoContainer;

    @BindView(R.id.signature_container)
    ImageView mSignatureContainer;

    @BindView(R.id. tv_header)
    TextView mHeader;

    @BindView(R.id.et_name)
    EditText mName;

    @BindView(R.id.et_last_name)
    EditText mLastName;

    @BindView(R.id.et_address)
    EditText mAddress;

    @BindView(R.id.et_birth_date)
    EditText mBirthDate;

    @BindView(R.id.et_phone_number)
    EditText mPhoneNumber;

    @BindView(R.id.request_submit_button)
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

    @OnClick(R.id.request_submit_button)
    public void onClick(View view) {

    }
}
