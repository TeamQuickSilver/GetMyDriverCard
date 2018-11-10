package com.quicksilver.getmydrivercard.views.step3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

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

        if (!isDeviceSupportFrontCamera(getApplicationContext())) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn't have front camera",
                    Toast.LENGTH_LONG).show();
            // will close the app if the device doesn't have camera
            finish();
        } else if (!isDeviceSupportCamera(getApplicationContext())) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn't have camera",
                    Toast.LENGTH_LONG).show();
            // will close the app if the device doesn't have camera
            finish();
        } else {
            isDeviceSupportCamera(getApplicationContext());
        }
            isDeviceSupportFrontCamera(getApplicationContext());

//        Button btnNextStep = findViewById(R.id.btn_next);
//        btnNextStep.setOnClickListener(v -> {
//            navigateToNextStep();
//        });
    }


    /**
     * Checks whether device has camera or not. This method not necessary if
     * android:required="true" is used in manifest file
     */
    static boolean isDeviceSupportCamera(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    /**
     * Checks whether device has front camera or not. This method not necessary if
     * android:required="true" is used in manifest file
     */
    static boolean isDeviceSupportFrontCamera(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);
    }

    @Override
    public void navigateToNextStep(Application application, byte[] imageBytes) {
        Intent intent = new Intent(this, IdCardPhotoActivity.class);
        intent.putExtra(Constants.APPLICATION, application);
        if(mApplication.getApplicationImages() == null) {
            mApplication.setApplicationImages(new ApplicationImages());
        }
        mApplication.getApplicationImages().setPersonImage(imageBytes);
        intent.putExtra(Constants.APPLICATION, mApplication);
        intent.putExtra(Constants.USER, mUser);
        startActivity(intent);
    }
}
