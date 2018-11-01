package com.quicksilver.getmydrivercard.views.step2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.views.BaseDrawerActivity;

import javax.inject.Inject;

public class Step2Activity extends BaseDrawerActivity {
    private static final int IDENTIFIER = 10;
    private String mReason;
    private FragmentTransaction mTransaction;

    @Inject
    NewCardFragment mNewCardFragment;

    @Inject
    LostStolenMalfunctionCardFragment mLostStolenMalfunctionFragment;

    @Inject
    ChangeCardFragment mChangeCardFragment;

    @Inject
    RenewCardFragment mRenewCardFragment;

    @Inject
    ExchangeCardFragment mExchangeCardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        Intent step1Intent = getIntent();
        mReason = step1Intent.getStringExtra(Constants.INTENT_REASON);

        mTransaction = getSupportFragmentManager().beginTransaction();
        arrangeFragments(mReason);
    }

    private void arrangeFragments(String reason) {
        switch (reason) {
            case Constants.NEW_CARD:
                mTransaction.replace(R.id.content, mNewCardFragment).commit();
                break;
            case Constants.LOST_TEXT:
            case Constants.STOLEN_TEXT:
            case Constants.MALFUNCTION_BROKEN_TEXT:
                mTransaction.replace(R.id.content, mLostStolenMalfunctionFragment).commit();
                break;
            case Constants.ADDRESS_CHANGE:
            case Constants.NAME_CHANGE:
            case Constants.PHOTO_CHANGE:
            case Constants.DRIVING_LICENSE_CHANGE:
                mTransaction.replace(R.id.content, mChangeCardFragment).commit();
                break;
            case Constants.EXCHANGE_CARD:
                mTransaction.replace(R.id.content, mExchangeCardFragment).commit();
                break;
            case Constants.RENEW_CARD:
                mTransaction.replace(R.id.content, mRenewCardFragment).commit();
                break;
            case Constants.WITHDRAWN_CARD:
                // TODO
                break;
        }
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }
}
