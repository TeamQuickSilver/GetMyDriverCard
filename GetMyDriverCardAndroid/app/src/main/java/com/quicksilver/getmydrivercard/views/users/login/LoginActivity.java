package com.quicksilver.getmydrivercard.views.users.login;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.views.step1.Step1Activity;
import com.quicksilver.getmydrivercard.views.users.register.RegisterActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends DaggerAppCompatActivity implements LoginContracts.Navigator {
    @Inject
    LoginContracts.Presenter mPresenter;

    @Inject
    LoginFragment mView;

    public LoginActivity() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    public void navigateToStep1() {
        Intent intentToStep1 = new Intent(this, Step1Activity.class);
        startActivity(intentToStep1);
    }

    @Override
    public void navigateToRegister() {
        Intent goToRegisterIntent = new Intent(this, RegisterActivity.class);
        startActivity(goToRegisterIntent);
    }
}
