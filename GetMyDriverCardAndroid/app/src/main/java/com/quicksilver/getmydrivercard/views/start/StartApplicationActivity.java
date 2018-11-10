package com.quicksilver.getmydrivercard.views.start;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class StartApplicationActivity extends DaggerAppCompatActivity implements StartApplicationContracts.Navigator {

    @Inject
    StartApplicationContracts.Presenter mApplicationStartPresenter;

    @Inject
    StartApplicationFragment mStartApplicationFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_application);

        mStartApplicationFragment.setNavigator(this);
        mStartApplicationFragment.setPresenter(mApplicationStartPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mStartApplicationFragment)
                .commit();
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(
                this,
                HomeActivity.class
        );

        startActivity(intent);
    }
}
