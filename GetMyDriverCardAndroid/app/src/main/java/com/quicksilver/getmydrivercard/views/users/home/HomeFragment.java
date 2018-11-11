package com.quicksilver.getmydrivercard.views.users.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.quicksilver.getmydrivercard.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeContracts.View {

    private HomeContracts.Presenter mPresenter;
    private HomeContracts.Navigator mNavigator;

    @BindView(R.id.btn_login)
    Button mLoginButton;

    @BindView(R.id.btn_register)
    Button mRegisterButton;

    @BindView(R.id.tv_or_line)
    TextView mLine;

    @Inject
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setPresenter(HomeContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(HomeContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnClick({R.id.btn_login, R.id.btn_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mNavigator.navigateToLogin();
                break;
            case R.id.btn_register:
                mNavigator.navigateToRegister();
                break;
        }
    }
}
