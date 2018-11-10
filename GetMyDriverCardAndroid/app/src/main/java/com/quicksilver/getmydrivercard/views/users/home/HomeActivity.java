package com.quicksilver.getmydrivercard.views.users.home;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.views.users.login.LoginActivity;
import com.quicksilver.getmydrivercard.views.users.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class HomeActivity extends DaggerAppCompatActivity implements HomeContracts.Navigator {

    @Inject
    HomeFragment mView;

    @Inject
    HomeContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    public void navigateToLogin() {
        Intent goToLoginIntent = new Intent(this, LoginActivity.class);
        startActivity(goToLoginIntent);
    }

    @Override
    public void navigateToRegister() {
        Intent intentToRegister = new Intent(this, RegisterActivity.class);
        intentToRegister.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intentToRegister);
    }
}
