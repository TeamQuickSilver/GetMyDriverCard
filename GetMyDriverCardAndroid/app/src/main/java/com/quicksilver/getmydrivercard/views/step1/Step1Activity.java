package com.quicksilver.getmydrivercard.views.step1;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.views.BaseDrawerActivity;
import com.quicksilver.getmydrivercard.views.step2.Step2Activity;

import javax.inject.Inject;

public class Step1Activity extends BaseDrawerActivity implements Step1Contracts.Navigator {
    public static final int IDENTIFIER = 2;

    @Inject
    Step1Fragment mView;

    @Inject
    Step1Contracts.Presenter mPresenter;


    public Step1Activity() {

    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);

        setSupportActionBar(getDrawerToolbar());

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    public void navigateToStep2(String reason, User user) {
        Intent goToStep2Intent = new Intent(this, Step2Activity.class);
        goToStep2Intent.putExtra(Constants.REASON, reason);
        goToStep2Intent.putExtra(Constants.USER, user);

        startActivity(goToStep2Intent);
    }
}
