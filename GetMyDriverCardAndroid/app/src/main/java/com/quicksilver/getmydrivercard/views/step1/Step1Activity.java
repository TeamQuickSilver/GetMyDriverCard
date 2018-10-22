package com.quicksilver.getmydrivercard.views.step1;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.views.step2.Step2Activity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class Step1Activity extends DaggerAppCompatActivity implements Step1Contracts.Navigator {
    private static final String REASON = "REASON";

    @Inject
    Step1Fragment mView;

    @Inject
    Step1Contracts.Presenter mPresenter;


    public Step1Activity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    public void navigateToStep2(String reason) {
        Intent goToStep2Intent = new Intent(this, Step2Activity.class);
        goToStep2Intent.putExtra(REASON, reason);

        startActivity(goToStep2Intent);
    }
}
