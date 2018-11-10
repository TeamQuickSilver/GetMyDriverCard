package com.quicksilver.getmydrivercard.views.start;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartApplicationFragment extends Fragment implements StartApplicationContracts.View {

    private StartApplicationContracts.Presenter mPresenter;
    private StartApplicationContracts.Navigator mNavigator;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Inject
    public StartApplicationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start_application, container, false);

        ButterKnife.bind(this, view);

        mProgressBar.getIndeterminateDrawable().setColorFilter(0xFF3568A3, android.graphics.PorterDuff.Mode.MULTIPLY);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.load();
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(StartApplicationContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(StartApplicationContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToHome() {
        mNavigator.navigateToHome();
    }

}
