package com.quicksilver.getmydrivercard.views.step2;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class NewCardActivityDocuments extends DaggerAppCompatActivity implements Step2Contracts.Navigator {
    @Inject
    NewCardFragmentDocuments mNewCardFragmentDocuments;
    private String mReason;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card_documents);

        mNewCardFragmentDocuments.setNavigator(this);
        Intent intent = getIntent();
        mReason = intent.getStringExtra(Constants.REASON);
        mUser = (User)intent.getSerializableExtra(Constants.USER);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, mNewCardFragmentDocuments)
                .commit();
    }

    @Override
    public void navigateToNextStep(Application application) {
        Intent intent = new Intent(this, NewCardPart3Activity.class);
        intent.putExtra(Constants.APPLICATION, application);
        intent.putExtra(Constants.REASON, mReason);
        intent.putExtra(Constants.USER, mUser);
        startActivity(intent);
    }
}
