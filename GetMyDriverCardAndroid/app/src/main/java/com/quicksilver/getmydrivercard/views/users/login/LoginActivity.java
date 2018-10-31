package com.quicksilver.getmydrivercard.views.users.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.views.BaseDrawerActivity;
import com.quicksilver.getmydrivercard.views.requests.RequestsActivity;
import com.quicksilver.getmydrivercard.views.step1.Step1Activity;
import com.quicksilver.getmydrivercard.views.users.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginActivity extends BaseDrawerActivity implements LoginContracts.Navigator {

    public static final int IDENTIFIER = 3;

    @Inject
    LoginContracts.Presenter mPresenter;

    @Inject
    LoginFragment mView;
    private GestureDetectorCompat mGestureDetector;

    public LoginActivity() {

    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        setSupportActionBar(getDrawerToolbar());

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    public void navigateToStep1(User user) {
        Intent intentToStep1 = new Intent(this, Step1Activity.class);
        intentToStep1.putExtra(Constants.USER_TEXT, user);
        startActivity(intentToStep1);
    }

    @Override
    public void navigateToRegister() {
        Intent intentToRegister = new Intent(this, RegisterActivity.class);
        intentToRegister.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intentToRegister);
//        finish();
    }

    @Override
    public void navigateToRequests(User user) {
        Intent intentToRequest = new Intent(this, RequestsActivity.class);
        intentToRequest.putExtra(Constants.USER_TEXT, user);
        startActivity(intentToRequest);
    }
}
