package com.quicksilver.getmydrivercard.views.preview;

import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.OnClick;

public class PreviewActivity extends BaseDrawerActivity implements PreviewContracts.Navigator {

    @Inject
    PreviewFragment mView;

    @Inject
    PreviewContracts.Presenter mPresenter;

    private Application mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        setSupportActionBar(getDrawerToolbar());

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();

    }

    @OnClick(R.id.request_submit_button)
    void onSubmitButtonClicked() {

    }

    @Override
    protected int getIdentifier() {
        return 0;
    }

    @Override
    public void navigateTo(String reason) {

    }
}