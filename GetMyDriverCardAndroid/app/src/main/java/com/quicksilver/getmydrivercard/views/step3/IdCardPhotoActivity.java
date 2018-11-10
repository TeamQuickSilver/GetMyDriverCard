package com.quicksilver.getmydrivercard.views.step3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class IdCardPhotoActivity extends DaggerAppCompatActivity implements Step3Contracts.Navigator {

    @Inject
    CameraFragment mView;

    private User mUser;
    private Application mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_card_photo);

        mView.setNavigator(this);

//        Intent intent = getIntent();
//        mUser = (User)intent.getSerializableExtra(Constants.USER);
//        mApplication = (Application)intent.getSerializableExtra(Constants.APPLICATION);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();

//        if (!CameraUtils.isDeviceSupportCamera(getApplicationContext())) {
//            Toast.makeText(getApplicationContext(),
//                    "Sorry! Your device doesn't have camera",
//                    Toast.LENGTH_LONG).show();
//            // will close the app if the device doesn't have camera
//            finish();
//        }
//            CameraUtils.isDeviceSupportCamera(getApplicationContext());

    }


    @Override
    public void navigateToNextStep(Application application, byte[] imageBytes) {
        Intent intent = new Intent(this, DrivingLicensePhotoActivity.class);
        application.getApplicationImages().setIdentityCardImage(imageBytes);
        intent.putExtra(Constants.APPLICATION, application);
        intent.putExtra(Constants.USER, mUser);
        startActivity(intent);
    }
}
