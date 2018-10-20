package com.quicksilver.getmydrivercard.views.users.register;

import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class RegisterActivity extends DaggerAppCompatActivity implements RegisterContracts.Navigator{

    @Inject
    RegisterContracts.Presenter mRegisterPresenter;

    @Inject
    RegisterFragment mRegisterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRegisterFragment.setPresenter(mRegisterPresenter);
        mRegisterFragment.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mRegisterFragment)
                .commit();
    }

    @Override
    public void navigateToStep1() {

    }

    @Override
    public void navigateToLogin() {

    }
}
