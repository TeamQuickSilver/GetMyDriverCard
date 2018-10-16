package com.quicksilver.getmydrivercard.views.users.login;

import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;

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
}
