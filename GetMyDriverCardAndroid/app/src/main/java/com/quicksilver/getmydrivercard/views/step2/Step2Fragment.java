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
        View newCardView = inflater.inflate(R.layout.fragment_new_card, container, false);
        View otherReasonsView = inflater.inflate(R.layout.fragmen_other_reasons, container, false);

        Intent step1Intent = getActivity().getIntent();
        mReason = step1Intent.getStringExtra(INTENT_REASON);

        if(mReason.equals(NEW_CARD)) {
            return newCardView;
        } else {
            return otherReasonsView;
        }
    }
}
