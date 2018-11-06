package com.quicksilver.getmydrivercard.views.step1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.User;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step1Fragment extends Fragment implements Step1Contracts.View {
    private Step1Contracts.Presenter mPresenter;
    private Step1Contracts.Navigator mNavigator;

    @BindView(R.id.cb_new_card)
    CheckBox mNewCard;

    @BindView(R.id.cb_change_card)
    CheckBox mChangeCard;

    @BindView(R.id.cb_exchange_card)
    CheckBox mExchangeCard;

    @BindView(R.id.cb_renew_card)
    CheckBox mRenewCard;

    @BindView(R.id.cb_withdrawn_card)
    CheckBox mWithdrawnCard;

    @BindView(R.id.spinner_change_card_reason)
    Spinner mSpinner;
    private String mReason;
    private User mUser;
    private ArrayAdapter<String> mArrayAdapter;
    private int mSpinnerItemId;

    @Inject
    public Step1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step1, container, false);

        ButterKnife.bind(this, view);
        String[] reasons = getResources().getStringArray(R.array.spinner_card_change_reason);
        mArrayAdapter = new ArrayAdapter<>(
                Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_dropdown_item, reasons);
        mSpinner.setAdapter(mArrayAdapter);

        Intent loginIntent = getActivity().getIntent();
        mUser = (User) loginIntent.getSerializableExtra(Constants.USER_TEXT);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(Step1Contracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(Step1Contracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnClick({R.id.cb_new_card, R.id.cb_change_card, R.id.cb_exchange_card,
            R.id.cb_renew_card, R.id.cb_withdrawn_card, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cb_new_card:
                uncheckedAll();
                mNewCard.setChecked(true);
                mReason = Constants.NEW_CARD;
                break;
            case R.id.cb_change_card:
                uncheckedAll();
                mChangeCard.setChecked(true);
                // Default value
//                if(mReason == null || mReason.equals(Constants.NEW_CARD) ||
//                        mReason.equals(Constants.EXCHANGE_CARD) || mReason.equals(Constants.RENEW_CARD)
//                        || mReason.equals(Constants.WITHDRAWN_CARD)) {
//
//                    mReason = Constants.LOST_TEXT;
//                } else {
//                    mReason = Constants.CHANGE_CARD;
//                }
                break;
            case R.id.cb_exchange_card:
                uncheckedAll();
                mExchangeCard.setChecked(true);
                mReason = Constants.EXCHANGE_CARD;
                break;
            case R.id.cb_renew_card:
                uncheckedAll();
                mRenewCard.setChecked(true);
                mReason = Constants.RENEW_CARD;
                break;
            case R.id.cb_withdrawn_card:
                uncheckedAll();
                mWithdrawnCard.setChecked(true);
                mReason = Constants.WITHDRAWN_CARD;
                break;
            case R.id.btn_next:
                boolean hasReason = checkReasons();

                if(!hasReason) {
                    return;
                }

                mNavigator.navigateToStep2(mReason, mUser);
                break;
        }
    }

    private boolean checkReasons() {
        if(mNewCard.isChecked()) {
            mReason = Constants.NEW_CARD;
        } else if(mChangeCard.isChecked()) {
            if(mReason == null || mReason.equals(Constants.NEW_CARD) ||
                    mReason.equals(Constants.EXCHANGE_CARD) || mReason.equals(Constants.RENEW_CARD)
                    || mReason.equals(Constants.WITHDRAWN_CARD)) {

                mReason = Constants.LOST_CARD;
            }
            //We have true reason
            System.out.println();
        } else if(mExchangeCard.isChecked()) {
            mReason = Constants.EXCHANGE_CARD;
        } else if(mRenewCard.isChecked()) {
            mReason = Constants.RENEW_CARD;
        } else if (mWithdrawnCard.isChecked()) {
            mReason = Constants.WITHDRAWN_CARD;
        } else {
            Toast.makeText(getContext(), Constants.MESSAGE, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @OnItemSelected(R.id.spinner_change_card_reason)
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        mReason = Objects.requireNonNull(mArrayAdapter.getItem(position)).toUpperCase();
    }

    private void uncheckedAll() {
        mNewCard.setChecked(false);
        mChangeCard.setChecked(false);
        mExchangeCard.setChecked(false);
        mRenewCard.setChecked(false);
        mWithdrawnCard.setChecked(false);

    }
}
