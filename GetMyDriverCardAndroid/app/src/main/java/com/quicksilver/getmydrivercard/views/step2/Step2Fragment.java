package com.quicksilver.getmydrivercard.views.step2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step2Fragment extends Fragment {
    private static String mReason;
    @BindView(R.id.relative_layout)
    RelativeLayout mRelativeLayout;

    public Step2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step2, container, false);

        ButterKnife.bind(this, view);

        Intent step1Intent = getActivity().getIntent();
        mReason = step1Intent.getStringExtra(Constants.INTENT_REASON);

        createViewElements();

        return view;
    }

    private void createViewElements() {
        switch (mReason) {
            case Constants.NEW_CARD:
                createNewCardView();
                break;
            case Constants.CHANGE_CARD:
                createChangeCardView();
                break;
            case Constants.EXCHANGE_CARD:
                createExchangeCardView();
                break;
            case Constants.RENEW_CARD:
                createRenewCardView();
                break;
            case Constants.WITHDRAWN_CARD:
                createWithdrawnCardView();
                break;
        }
    }

    private void createWithdrawnCardView() {

    }

    private void createRenewCardView() {
        TextView textView = new TextView(getContext());
        textView.setId(1);
        textView.setText(Constants.DATE_OF_EXPIRE);
        RelativeLayout.LayoutParams layoutParamsTextView = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsTextView.addRule(RelativeLayout.BELOW, textView.getId());
        mRelativeLayout.addView(textView, layoutParamsTextView);
    }

    private void createExchangeCardView() {
    }

    private void createChangeCardView() {

    }

    private void createNewCardView() {

    }
}
