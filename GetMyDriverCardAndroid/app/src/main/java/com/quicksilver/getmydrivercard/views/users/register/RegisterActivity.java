package com.quicksilver.getmydrivercard.views.users.register;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.views.step1.Step1Activity;
import com.quicksilver.getmydrivercard.views.users.login.LoginActivity;

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
        Intent goToStep1Intent = new Intent(this, Step1Activity.class);
        startActivity(goToStep1Intent);
    }

    @Override
    public void navigateToLogin() {
        Intent goToLoginIntent = new Intent(this, LoginActivity.class);
        startActivity(goToLoginIntent);
    }
}
