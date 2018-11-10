package com.quicksilver.getmydrivercard.views.preview;

import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;

import javax.inject.Inject;

import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class PreviewActivity extends DaggerAppCompatActivity implements PreviewContracts.Navigator {

    @Inject
    PreviewFragment mView;

    @Inject
    PreviewContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();

    }

    @OnClick()
    void onSubmitButtonClicked() {

    }

    @Override
    public void navigateTo(String reason) {

    }
}