package com.quicksilver.getmydrivercard.views.users.login;

import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends DaggerAppCompatActivity implements LoginContracts.Navigator {
    private  LoginContracts.Presenter mPresenter;

    private  LoginFragment mView;

    public LoginActivity() {

    }

    @Inject
    public LoginActivity(LoginContracts.Presenter mPresenter, LoginFragment loginFragment) {
        this.mPresenter = mPresenter;
        this.mView = loginFragment;
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
