package com.quicksilver.getmydrivercard.views.preview;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.views.requests.RequestsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class PreviewActivity extends DaggerAppCompatActivity implements PreviewContracts.Navigator {

    @Inject
    PreviewFragment mView;

    @Inject
    PreviewContracts.Presenter mPresenter;

    private Application mApplication;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        ButterKnife.bind(this);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        Intent intent = getIntent();
        mUser = (User)intent.getSerializableExtra(Constants.USER);
        mApplication = (Application)intent.getSerializableExtra(Constants.APPLICATION);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    public void navigateTo(Application application) {
        Intent intent = new Intent(this, RequestsActivity.class);
        intent.putExtra(Constants.APPLICATION, application);
        intent.putExtra(Constants.USER, mUser);
        startActivity(intent);
        finish();
    }
}