package com.quicksilver.getmydrivercard.views.users.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.views.step1.Step1Activity;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContracts.View, GoogleApiClient.OnConnectionFailedListener {
    private static final int REQ_CODE = 7444;
    private LoginContracts.Presenter mPresenter;
    private LoginContracts.Navigator mNavigator;

    @BindView(R.id.btn_login)
    Button mLoginButton;

    @BindView(R.id.google_sign_in_button)
    SignInButton mGoogleSignInButton;

    private GoogleApiClient mGoogleApiClient;

    @Inject
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient
                .Builder(Objects.requireNonNull(getContext()))
                .enableAutoManage(Objects.requireNonNull(getActivity()), this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(LoginContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(LoginContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnClick({R.id.btn_login, R.id.google_sign_in_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                // Handle boolean result from login and replace true value below with it
                handleResult(true);
                break;
            case R.id.google_sign_in_button:
                Intent googleSignInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(googleSignInIntent, REQ_CODE);
                break;
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE) {
            GoogleSignInResult googleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(googleSignInResult);
        }
    }

    private void handleResult(GoogleSignInResult googleSignInResult) {
        if(googleSignInResult.isSuccess()) {
            Intent intent = new Intent(getContext(), Step1Activity.class);
            startActivity(intent);
        }
    }

    private void handleResult(boolean signInResult) {
        if(signInResult) {
            Intent intent = new Intent(getContext(), Step1Activity.class);
            startActivity(intent);        }
    }
}
