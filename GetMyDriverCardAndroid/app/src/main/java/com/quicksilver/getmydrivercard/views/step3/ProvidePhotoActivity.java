package com.quicksilver.getmydrivercard.views.step3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.R;

public class ProvidePhotoActivity extends Activity {

    private static final int CAMERA_CAPTURE_IMEGE_REQUEST_CODE = 100;
    private static String storagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_photo);

        if (!CameraUtils.isDeviceSupportCamera(getApplicationContext())) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your divex=ce doesn't support camera",
                    Toast.LENGTH_LONG).show();
            finish();
        }

//        Button btnTakePicture = findViewById(R.id.btnCapturePicture);
//        btnTakePicture.setOnClickListener(v -> {
//            if (CameraUtils.checkPerissions(getApplicationContext())) {
//                captureImage();
//            } else {
//                requestCameraPermission();
//            }
//        });

//        Button btnCamera = findViewById(R.id.btnCamera);
//        btnCamera.setOnClickListener(v -> {
//            Intent camera = new Intent(ProvidePhotoActivity.this, )
//        });
    }

    private void requestCameraPermission() {
    }

    private void captureImage() {

    }
}
