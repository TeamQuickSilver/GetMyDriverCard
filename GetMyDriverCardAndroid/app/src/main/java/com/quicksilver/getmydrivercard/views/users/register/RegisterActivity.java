package com.quicksilver.getmydrivercard.views.users.register;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.views.BaseDrawerActivity;
import com.quicksilver.getmydrivercard.views.step1.Step1Activity;
import com.quicksilver.getmydrivercard.views.users.login.LoginActivity;

import javax.inject.Inject;

public class RegisterActivity extends BaseDrawerActivity implements RegisterContracts.Navigator {

    public static final int IDENTIFIER = 4;

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
        finish();
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }
}
