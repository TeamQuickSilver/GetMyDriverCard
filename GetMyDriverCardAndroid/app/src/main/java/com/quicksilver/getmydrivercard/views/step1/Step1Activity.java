package com.quicksilver.getmydrivercard.views.step1;

import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class Step1Activity extends DaggerAppCompatActivity implements Step1Contracts.Navigator {
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
}
