package com.quicksilver.getmydrivercard.views.step4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.views.step1.Step1Contracts;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step4Fragment extends Fragment implements Step4Contracts.View {

    private Step1Contracts.Presenter mPresenter;
    private Step1Contracts.Navigator mNavigator;

    @Inject
    public Step4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step4, container, false);
    }

    @Override
    public void setPresenter(Step4Contracts.Presenter presenter) {

    }

    @Override
    public void setNavigator(Step4Contracts.Navigator navigator) {

    }
}
