package com.quicksilver.getmydrivercard.views.requests;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.views.BaseDrawerActivity;
import com.quicksilver.getmydrivercard.views.requestdetails.RequestDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class RequestsActivity extends BaseDrawerActivity implements RequestsContracts.Navigator{
    public static final int IDENTIFIER = 1;
    @Inject
    RequestsContracts.Presenter mPresenter;

    @Inject
    RequestsFragment mRequestsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        ButterKnife.bind(this);
        mRequestsFragment.setPresenter(mPresenter);
        mRequestsFragment.setNavigator(this);

        setSupportActionBar(getDrawerToolbar());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, mRequestsFragment)
                .commit();
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToDetails(Application application) {
        Intent detailsIntent = new Intent(this, RequestDetailsActivity.class);
        detailsIntent.putExtra(Constants.APPLICATION_TEXT, application);

        startActivity(detailsIntent);
    }
}
