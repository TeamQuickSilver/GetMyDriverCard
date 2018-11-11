package com.quicksilver.getmydrivercard.views.step3;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.views.step4.Step4Activity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class ProvidePhotoActivity extends DaggerAppCompatActivity implements Step3Contracts.Navigator {

    @Inject
    CameraFragment mView;
    private User mUser;
    private Application mApplication;
    private String mReason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_photo);

        mView.setNavigator(this);

        Intent intent = getIntent();
        mUser = (User)intent.getSerializableExtra(Constants.USER);
        mApplication = (Application)intent.getSerializableExtra(Constants.APPLICATION);
        mReason = intent.getStringExtra(Constants.REASON);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
//
//        Button btnNextStep = findViewById(R.id.btn_next);
//        btnNextStep.setOnClickListener(v -> {
//
//        });
    }

    @Override
    public void navigateToNextStep(Application application, byte[] imageBytes) {
        Intent intent = null;
        switch (mReason) {
            case Constants.NEW_CARD:
            case Constants.WITHDRAWN_CARD:
                intent = new Intent(this, IdCardPhotoActivity.class);
                break;
            case Constants.PHOTO_CHANGE:
                intent = new Intent(this, Step4Activity.class);
                break;
        }

        mApplication.getApplicationImages().setPersonImage(imageBytes);
        intent.putExtra(Constants.APPLICATION, mApplication);
        intent.putExtra(Constants.USER, mUser);
        startActivity(intent);
    }
}
