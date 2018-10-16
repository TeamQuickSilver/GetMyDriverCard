package com.quicksilver.getmydrivercard.views.users.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quicksilver.getmydrivercard.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContracts.View {

    private LoginContracts.Presenter mPresenter;
    private LoginContracts.Navigator mNavigator;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

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
}
