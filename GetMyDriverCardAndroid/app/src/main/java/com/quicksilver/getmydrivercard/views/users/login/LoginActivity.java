package com.quicksilver.getmydrivercard.views.users.login;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;
<<<<<<< HEAD
import com.quicksilver.getmydrivercard.models.User;
=======
import com.quicksilver.getmydrivercard.views.BaseDrawerActivity;
>>>>>>> 25554e8a12e674a62cf326c15a8c0cb9182c375f
import com.quicksilver.getmydrivercard.views.requests.RequestsActivity;
import com.quicksilver.getmydrivercard.views.step1.Step1Activity;
import com.quicksilver.getmydrivercard.views.users.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

<<<<<<< HEAD
public class LoginActivity extends DaggerAppCompatActivity implements LoginContracts.Navigator {
    private static final String USER_TEXT = "USER";
=======
public class LoginActivity extends BaseDrawerActivity implements LoginContracts.Navigator {

    public static final int IDENTIFIER = 3;

>>>>>>> 25554e8a12e674a62cf326c15a8c0cb9182c375f
    @Inject
    LoginContracts.Presenter mPresenter;

    @Inject
    LoginFragment mView;

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
        intentToStep1.putExtra(USER_TEXT, user);
        startActivity(intentToStep1);
    }

    @Override
    public void navigateToRegister() {
        Intent intentToRegister = new Intent(this, RegisterActivity.class);
        startActivity(intentToRegister);
    }

    @Override
    public void navigateToRequests(User user) {
        Intent intentToRequest = new Intent(this, RequestsActivity.class);
        intentToRequest.putExtra(USER_TEXT, user);
        startActivity(intentToRequest);
    }
}
