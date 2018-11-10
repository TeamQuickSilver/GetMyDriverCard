package com.quicksilver.getmydrivercard.views.step3;

import android.content.Intent;
import android.os.Bundle;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationImages;
import com.quicksilver.getmydrivercard.models.User;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class ProvidePhotoActivity extends DaggerAppCompatActivity implements Step3Contracts.Navigator {

    @Inject
    CameraFragment mView;
    private User mUser;
    private Application mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_photo);

        mView.setNavigator(this);

        Intent intent = getIntent();
        mUser = (User)intent.getSerializableExtra(Constants.USER);
        mApplication = (Application)intent.getSerializableExtra(Constants.APPLICATION);

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
        Intent intent = new Intent(this, IdCardPhotoActivity.class);
        if(mApplication.getApplicationImages() == null) {
            mApplication.setApplicationImages(new ApplicationImages());
        }
        mApplication.getApplicationImages().setPersonImage(imageBytes);
        intent.putExtra(Constants.APPLICATION, mApplication);
        intent.putExtra(Constants.USER, mUser);
        startActivity(intent);
    }
}
