package com.quicksilver.getmydrivercard.views.step2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.views.BaseDrawerActivity;
import com.quicksilver.getmydrivercard.views.step3.ProvidePhotoActivity;

import javax.inject.Inject;

public class Step2Activity extends BaseDrawerActivity implements Step2Contracts.Navigator {
    private static final int IDENTIFIER = 10;
    private String mReason;
    private FragmentTransaction mTransaction;

    @Inject
    Step2Contracts.Presenter mStep2Presenter;

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

    private static Application mApplication;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        Intent step1Intent = getIntent();
        mReason = step1Intent.getStringExtra(Constants.INTENT_REASON);
        mUser = (User)step1Intent.getSerializableExtra(Constants.USER);

        mNewCardFragment.setNavigator(this);
        mLostStolenMalfunctionFragment.setNavigator(this);
        mRenewCardFragment.setNavigator(this);
        mChangeCardFragment.setNavigator(this);
        mExchangeCardFragment.setNavigator(this);

//        mNewCardFragment.setPresenter(mStep2Presenter);
        mLostStolenMalfunctionFragment.setPresenter(mStep2Presenter);
        mRenewCardFragment.setPresenter(mStep2Presenter);
        mChangeCardFragment.setPresenter(mStep2Presenter);
        mExchangeCardFragment.setPresenter(mStep2Presenter);

        mTransaction = getSupportFragmentManager().beginTransaction();
        arrangeFragments(mReason);
    }

    private void arrangeFragments(String reason) {
        switch (reason) {
            case Constants.NEW_CARD:
            case Constants.WITHDRAWN_CARD:
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
        }
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToNextStep(Application application) {
        Intent intent = null;
        switch (mReason) {
            case Constants.NEW_CARD:
            case Constants.WITHDRAWN_CARD:
                intent = new Intent(this, NewCardActivityDocuments.class);
                break;
            default:
                intent = new Intent(this, ProvidePhotoActivity.class);
                break;
        }

        intent.putExtra(Constants.APPLICATION, application);
        intent.putExtra(Constants.REASON, mReason);
        intent.putExtra(Constants.USER, mUser);
        startActivity(intent);
    }
}

