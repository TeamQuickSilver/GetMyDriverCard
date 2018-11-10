package com.quicksilver.getmydrivercard.views.step3;


import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment implements Step3Contracts.View{

    // Camera activity request code
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static String imageStoragePath;

    private Step3Contracts.Presenter mPresenter;
    private Step3Contracts.Navigator mNavigator;

    @BindView(R.id.txt_desc)
    TextView mTextImage;

    @BindView(R.id.img_preview)
    ImageView mImagePreview;

    @BindView(R.id.btn_capture_picture)
    Button mButtonCamera;

    @BindView(R.id.btn_upload_picture)
    Button mButtonUpload;

    @BindView(R.id.btn_next)
    Button mButtonNext;

    private User mUser;
    private Application mApplication;
    private Intent mIntentData;
    private byte[] mImageBytes;

    @Inject
    public CameraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        ButterKnife.bind(this, view);
        mApplication = (Application) getActivity().getIntent().getSerializableExtra(Constants.APPLICATION);

        // Checking availability of the camera
        if (!CameraUtils.isDeviceSupportFrontCamera(getApplicationContext())) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn't support camera",
                    Toast.LENGTH_LONG).show();
            // will close the app if the device doesn't have camera
//            finish();
        }

        return view;
    }

    @Override
    public void setPresenter(Step3Contracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(Step3Contracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnClick({R.id.btn_capture_picture, R.id.btn_upload_picture})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_capture_picture:
                if (CameraUtils.checkPermissions(getApplicationContext())) {
                    captureImage();
                } else {
                    requestCameraPermission();
                }
                break;
            case R.id.btn_upload_picture:
                Intent intentToGallery = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI
                );
                startActivityForResult(intentToGallery, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
                break;
            case R.id.btn_next:
                if(mImageBytes == null) {
                    Toast.makeText(getApplicationContext(), Constants.PHOTO_ERROR, Toast.LENGTH_SHORT).show();
                    return;
                }

                mNavigator.navigateToNextStep(mApplication, mImageBytes);
                break;
        }
    }

    /**
     * Restoring store image path from saved instance state
     */
    private void restoreFromBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(CameraUtils.KEY_IMAGE_STORAGE_PATH)) {
                imageStoragePath = savedInstanceState.getString(CameraUtils.KEY_IMAGE_STORAGE_PATH);
                if (!TextUtils.isEmpty(imageStoragePath)) {
                    if (imageStoragePath.substring(imageStoragePath.lastIndexOf(".")).equals("." + CameraUtils.IMAGE_EXTENSION)) {
                        previewCapturedImage();
                    }
                }
            }
        }
    }

    /**
     * Requesting permissions using Dexter library
     */
    private void requestCameraPermission() {
        Dexter.withActivity(getActivity())
                .withPermissions(Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            captureImage();
                        } else if (report.isAnyPermissionPermanentlyDenied()) {
                            showPermissionsAlert();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }


    /**
     * Capturing Camera Image will launch camera app requested image capture
     */
    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File file = CameraUtils.getOutputMediaFile();
        if (file != null) {
            imageStoragePath = file.getAbsolutePath();
        }

        Uri fileUri = CameraUtils.getOutputMediaFileUri(getApplicationContext(), file);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        // start the image capture Intent
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
    }

    /**
     * Saving stored image path to saved instance state
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save file url in bundle as it will be null on screen orientation
        // changes
        outState.putString(CameraUtils.KEY_IMAGE_STORAGE_PATH, imageStoragePath);
    }

    /**
     * Restoring image path from saved instance state
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        onRestoreInstanceState(savedInstanceState);

        // get the file url
        imageStoragePath = savedInstanceState.getString(CameraUtils.KEY_IMAGE_STORAGE_PATH);
    }

    /**
     * Activity result method will be called after closing the camera
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            // Refreshing the gallery
            CameraUtils.refreshGallery(getApplicationContext(), imageStoragePath);

            // successfully captured the image
            // display it in image view
            mIntentData = data;
            previewCapturedImage();
        } else if (resultCode == RESULT_CANCELED) {
            // user cancelled Image capture
            Toast.makeText(getApplicationContext(),
                    "User cancelled image capture", Toast.LENGTH_SHORT)
                    .show();
        } else {
            // failed to capture image
            Toast.makeText(getApplicationContext(),
                    "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    /**
     * Display image from gallery
     */
    private void previewCapturedImage() {
        try {
            TextView txtPreview = mTextImage;
            txtPreview.setVisibility(View.GONE);

            ImageView imgPreview = mImagePreview;
            imgPreview.setVisibility(View.VISIBLE);
            Bitmap bitmap = CameraUtils.optimizeBitmap(CameraUtils.BITMAP_SAMPLE_SIZE, imageStoragePath);
            imgPreview.setImageBitmap(bitmap);

//            Uri uri = mIntentData.getData();

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            mImageBytes = stream.toByteArray();
            mNavigator.navigateToNextStep(mApplication, mImageBytes);

//            try {
//                InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);
//
//                mImageBytes = convertUriIntoByteArray(inputStream);
////                mApplication.getApplicationImages().setPersonImage(convertUriIntoByteArray(inputStream));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public byte[] convertUriIntoByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        byte[] buffer = new byte[Constants.BUFFER_SIZE];

        int len = 0;
        while((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        return byteBuffer.toByteArray();
    }

    /**
     * Alert dialog to navigate to app settings
     * to enable necessary permissions
     */
    private void showPermissionsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
        builder.setTitle("Permissions required!")
                .setMessage("Camera needs few permissions to work properly. Grant them in settings.")
                .setPositiveButton("GOTO SETTINGS", (dialog, which) -> CameraUtils.openSettings(getContext()))
                .setNegativeButton("CANCEL", (dialog, which) -> {
                }).show();
    }
}
