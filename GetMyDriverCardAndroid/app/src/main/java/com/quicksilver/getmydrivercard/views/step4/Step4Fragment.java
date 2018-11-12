package com.quicksilver.getmydrivercard.views.step4;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step4Fragment extends Fragment implements Step4Contracts.View {

    private Step4Contracts.Presenter mPresenter;
    private Step4Contracts.Navigator mNavigator;
    private Application mApplication;
    private User mUser;

    @Inject
    public Step4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step4, container, false);

        mApplication = (Application)getActivity().getIntent().getSerializableExtra(Constants.APPLICATION);
        mUser = (User)getActivity().getIntent().getSerializableExtra(Constants.USER);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(Step4Contracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(Step4Contracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToPreview() {
        mNavigator.navigateToPreview(mApplication);
    }

    public void createImageBytesFromUri(Uri contentUri) {
        try {
            InputStream inputStream = getActivity().getContentResolver().openInputStream(contentUri);

            byte[] imageBytes = mPresenter.convertUriIntoByteArray(inputStream);
            mApplication.getApplicationImages().setSignatureImage(imageBytes);
            mApplication.setUser(mUser);
            mApplication.setDateOfSubmission(new Date());

            navigateToPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
