package com.quicksilver.getmydrivercard.views.step1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step1Fragment extends Fragment implements Step1Contracts.View {
    private static final String NEW_CARD = "NEW_CARD";
    private static final String CHANGE_CARD = "CHANGE_CARD";
    private static final String EXCHANGE_CARD = "EXCHANGE_CARD";
    private static final String RENEW_CARD = "RENEW_CARD";
    private static final String WITHDRAWN_CARD = "WITHDRAWN_CARD";
    private static final String MESSAGE = "Please choose a reason";
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
    private String mReason;

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
        uncheckedAll();
        switch (view.getId()) {
            case R.id.cb_new_card:
                mNewCard.setChecked(true);
                mReason = NEW_CARD;
                break;
            case R.id.cb_change_card:
                mChangeCard.setChecked(true);
                mReason = CHANGE_CARD;
                break;
            case R.id.cb_exchange_card:
                mExchangeCard.setChecked(true);
                mReason = EXCHANGE_CARD;
                break;
            case R.id.cb_renew_card:
                mRenewCard.setChecked(true);
                mReason = RENEW_CARD;
                break;
            case R.id.cb_withdrawn_card:
                mWithdrawnCard.setChecked(true);
                mReason = WITHDRAWN_CARD;
                break;
            case R.id.btn_next:
                if(mReason == null) {
                    Toast.makeText(getContext(), MESSAGE, Toast.LENGTH_SHORT).show();
                    return;
                }
                mNavigator.navigateToStep2(mReason);
                break;
        }
    }

    private void uncheckedAll() {
        mNewCard.setChecked(false);
        mChangeCard.setChecked(false);
        mExchangeCard.setChecked(false);
        mRenewCard.setChecked(false);
        mWithdrawnCard.setChecked(false);
    }
}
