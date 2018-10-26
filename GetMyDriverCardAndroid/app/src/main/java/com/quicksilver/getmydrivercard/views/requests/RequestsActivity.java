package com.quicksilver.getmydrivercard.views.requests;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.views.BaseDrawerActivity;

public class RequestsActivity extends BaseDrawerActivity {

    public static final int IDENTIFIER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        setSupportActionBar(getDrawerToolbar());
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }
}
