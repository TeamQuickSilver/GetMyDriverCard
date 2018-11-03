package com.quicksilver.getmydrivercard.views.step2;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class NewCardPart3Activity extends DaggerAppCompatActivity implements Step2Contracts.Navigator {
    @Inject
    NewCardPart3Fragment mNewCardPart3Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card_part3);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, mNewCardPart3Fragment)
                .commit();
    }

    @Override
    public void navigateToNextStep(Application application) {
        // Step 3
        Intent intent = new Intent();
    }
}
