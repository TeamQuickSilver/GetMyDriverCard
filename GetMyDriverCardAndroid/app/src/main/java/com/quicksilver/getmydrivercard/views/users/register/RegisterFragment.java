package com.quicksilver.getmydrivercard.views.users.register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.views.OnSwipeTouchListener;

import org.apache.commons.validator.routines.EmailValidator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */

public class RegisterFragment extends Fragment implements RegisterContracts.View {
    private static final String REGISTER_ERROR = "User with this username already exists";
    private RegisterContracts.Presenter mPresenter;
    private RegisterContracts.Navigator mNavigator;

    @BindView(R.id.tv_go_to_login_form)
    TextView mGoToLoginForm;

    @BindView(R.id.btn_register)
    Button mRegisterButton;

    @BindView(R.id.et_email)
    EditText mEmailEdiText;

    @BindView(R.id.et_password)
    EditText mEditTextPassword;

    @Inject
    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this, view);

        view.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                mNavigator.navigateToLogin();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(RegisterContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setNavigator(RegisterContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void showRegisterError() {
        getActivity().runOnUiThread(() -> {
            Toast.makeText(getContext(), REGISTER_ERROR, Toast.LENGTH_SHORT).show();
        });
    }

    @OnClick({R.id.tv_go_to_login_form, R.id.btn_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_go_to_login_form:
                mNavigator.navigateToLogin();
                break;
            case R.id.btn_register:
                String email = mEmailEdiText.getText().toString();
                String password = mEditTextPassword.getText().toString();
                EmailValidator emailValidator = EmailValidator.getInstance();

                if(!emailValidator.isValid(email)) {
                    mEmailEdiText.setError(Constants.EMAIL_ERROR);
                    return;
                }

                if(password.length() < 6) {
                    mEditTextPassword.setError(Constants.PASSWORD_ERROR);
                    return;
                }

                User user = new User(email, password);
                mPresenter.register(user);
                break;
        }
    }

    @Override
    public void navigateToStep1() {
        mNavigator.navigateToStep1();
    }

//    @OnTextChanged({R.id.et_email, R.id.et_password})
//    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        String email = mEmailEdiText.getText().toString();
//    }
}
