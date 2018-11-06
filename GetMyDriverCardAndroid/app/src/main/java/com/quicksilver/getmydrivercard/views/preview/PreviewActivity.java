package com.quicksilver.getmydrivercard.views.preview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PreviewActivity extends Activity {

    @BindView(R.id.photo_container)
    ImageView mPhotoContainer;

    @BindView(R.id.signature_container)
    ImageView mSignatureContainer;

    @BindView(R.id.preview_header)
    TextView mHeaderMssg;

    @BindView(R.id.request_reason)
    TextView mHeaderMssgTwo;

    @BindView(R.id.cyr_name)
    EditText mCyrName;

    @BindView(R.id.cyr_surname)
    EditText mCyrSurname;

    @BindView(R.id.preview_name)
    EditText mName;

    @BindView(R.id.preview_surname)
    EditText mLastName;

    @BindView(R.id.preview_address)
    EditText mAddress;

    @BindView(R.id.preview_birth_date)
    EditText mBirthDate;

    @BindView(R.id.preview_number)
    EditText mPhoneNumber;

    @BindView(R.id.request_preview_submit_button)
    Button mSubmitButton;

    private Application mApplication;

    public static final String STATUS = "STATUS";
    public static final String REQUEST = "SUBMIT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent.getBooleanExtra(STATUS, false)) {
            mSubmitButton.setVisibility(View.VISIBLE);
        }
        mApplication = (Application) intent.getSerializableExtra(REQUEST);
    }

    @OnClick(R.id.request_preview_submit_button)
    void onSubmitButtonClicked() {

    }
}