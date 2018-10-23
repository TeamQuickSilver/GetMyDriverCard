package com.quicksilver.getmydrivercard.views.step2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quicksilver.getmydrivercard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step2Fragment extends Fragment {
    private static final String INTENT_REASON = "REASON";
    private static final String NEW_CARD = "NEW_CARD";
    private static String mReason;

    public Step2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step2, container, false);

        Intent step1Intent = getActivity().getIntent();
        mReason = step1Intent.getStringExtra(INTENT_REASON);

        createViewElements();

        return view;
    }

    private void createViewElements() {
        switch (mReason) {
            case "NEW_CARD":
                createNewCardView();
                break;
            case "CHANGE_CARD":
                break;
            case "EXCHANGE_CARD":
                break;
            case "RENEW_CARD":
                break;
            case "WITHDRAWN_CARD":
                break;
        }
    }

    private void createNewCardView() {

    }
}
