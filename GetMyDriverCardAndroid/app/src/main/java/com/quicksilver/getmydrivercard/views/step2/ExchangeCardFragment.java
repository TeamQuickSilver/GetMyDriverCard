package com.quicksilver.getmydrivercard.views.step2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.quicksilver.getmydrivercard.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExchangeCardFragment extends Fragment {
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
        // Navigate to Step 3
    }
}
