package com.quicksilver.getmydrivercard.views.step2;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class NewCardActivityDocuments extends DaggerAppCompatActivity implements Step2Contracts.Navigator {
    @Inject
    NewCardFragmentDocuments mNewCardFragmentDocuments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card_documents);

        mNewCardFragmentDocuments.setNavigator(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, mNewCardFragmentDocuments)
                .commit();
    }

    @Override
    public void navigateToNextStep(Application application) {
        Intent intent = new Intent();
    }
}
