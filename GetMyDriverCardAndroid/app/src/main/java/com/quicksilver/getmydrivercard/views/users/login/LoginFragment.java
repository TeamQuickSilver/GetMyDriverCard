package com.quicksilver.getmydrivercard.views.users.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.views.OnSwipeTouchListener;

import org.json.JSONException;

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
    private static final String PUBLIC_PROFILE_EMAIL = "public_profile email";
    private static final String EMAIL = "email";
    private static final String FIELDS = "fields";
    private LoginContracts.Presenter mPresenter;
    private LoginContracts.Navigator mNavigator;

    @BindView(R.id.btn_login)
    Button mLoginButton;

    @BindView(R.id.google_sign_in_button)
    SignInButton mGoogleSignInButton;

    @BindView(R.id.facebook_sign_in_button)
    LoginButton mFacebookLoginButton;

    @BindView(R.id.tv_go_to_register_form)
    TextView mGoToRegisterTextView;

    @BindView(R.id.et_email)
    EditText mEmailEditText;

    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    private AccessToken mAccessToken;
    private CallbackManager mCallBackManager;
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

        mFacebookLoginButton.setFragment(this);
        mFacebookLoginButton.setReadPermissions(PUBLIC_PROFILE_EMAIL);
        mCallBackManager = CallbackManager.Factory.create();

        configFacebookLogin();

        view.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                mNavigator.navigateToRegister();
            }
        });

        return view;
    }

    private void configFacebookLogin() {
        mFacebookLoginButton.registerCallback(mCallBackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mFacebookLoginButton.setReadPermissions(PUBLIC_PROFILE_EMAIL);
                mAccessToken = loginResult.getAccessToken();

                boolean isFacebookLoginSucceeded = mAccessToken != null && !mAccessToken.isExpired();

                GraphRequest request = GraphRequest.newMeRequest(mAccessToken, (object, response) -> {
                    try {
                        if (object.has(EMAIL)) {
                            String facebookProfileEmail = object.getString(EMAIL);
                            User facebookUser = new User(facebookProfileEmail);

                            mPresenter.loginGoogleOrFacebookUser(facebookUser);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                });

                Bundle params = new Bundle();
                params.putString(FIELDS, EMAIL);
                request.setParameters(params);
                request.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

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

    @Override
    public void navigateToStep1(User user) {
        mNavigator.navigateToStep1(user);
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToRequests(User user) {
        mNavigator.navigateToRequests(user);
    }

    @OnClick({R.id.btn_login, R.id.google_sign_in_button, R.id.tv_go_to_register_form})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String username = mEmailEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                User user = new User(username, password);
                mPresenter.login(user);
                break;
            case R.id.google_sign_in_button:
                Intent googleSignInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(googleSignInIntent, REQ_CODE);
                break;
            case R.id.tv_go_to_register_form:
                mNavigator.navigateToRegister();
                break;
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // Required for google login functionality
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallBackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE) {
            GoogleSignInResult googleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(googleSignInResult);
        }
    }

    private void handleResult(GoogleSignInResult googleSignInResult) {
        boolean isGoogleLoginSucceeded = googleSignInResult.isSuccess();
        String googleProfileEmail = null;
        if (isGoogleLoginSucceeded) {
            googleProfileEmail = googleSignInResult.getSignInAccount().getEmail();
        }

        User user = new User(googleProfileEmail);
        mPresenter.loginGoogleOrFacebookUser(user);
    }
}
