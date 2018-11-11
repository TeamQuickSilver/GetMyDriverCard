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

public class DrivingLicensePhotoActivity extends DaggerAppCompatActivity implements Step3Contracts.Navigator {

    @Inject
    CameraFragment mView;

    private User mUser;
    private Application mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_license_photo);

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
    public void navigateToNextStep(Application application, byte[] imageBytes) {
        Intent intent = new Intent(this, Step4Activity.class);
        application.getApplicationImages().setDrivingLicenseImage(imageBytes);
        intent.putExtra(Constants.APPLICATION, application);
        intent.putExtra(Constants.USER, mUser);
        startActivity(intent);
    }
}
