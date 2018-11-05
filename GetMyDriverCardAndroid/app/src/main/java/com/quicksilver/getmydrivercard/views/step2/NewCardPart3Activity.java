package com.quicksilver.getmydrivercard.views.step2;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.views.step3.ProvidePhotoActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class NewCardPart3Activity extends DaggerAppCompatActivity implements Step2Contracts.Navigator {
    @Inject
    NewCardPart3Fragment mNewCardPart3Fragment;
    private String mReason;
    private User mUser;
    private Application mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card_part3);

        mNewCardPart3Fragment.setNavigator(this);

        Intent intent = getIntent();
        mReason = intent.getStringExtra(Constants.REASON);
        mUser = (User)intent.getSerializableExtra(Constants.USER);
        mApplication = (Application)intent.getSerializableExtra(Constants.APPLICATION);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, mNewCardPart3Fragment)
                .commit();
    }

    @Override
    public void navigateToNextStep(Application application) {
        Intent intent = new Intent(this, ProvidePhotoActivity.class);
        intent.putExtra(Constants.APPLICATION, application);
        intent.putExtra(Constants.REASON, mReason);
        intent.putExtra(Constants.USER, mUser);
        startActivity(intent);
    }
}
