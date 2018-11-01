package com.quicksilver.getmydrivercard.views.step2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.R;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LostStolenMalfunctionCardFragment extends Fragment {
    @BindView(R.id.tv_date)
    TextView mDate;

    @BindView(R.id.tv_place)
    TextView mPlace;

    @BindView(R.id.et_place)
    EditText mPlaceEditText;

    @BindView(R.id.date_picker)
    DatePicker mDatePicker;

    @Inject
    public LostStolenMalfunctionCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lost_stolen_malfunction_card, container, false);

        ButterKnife.bind(this, view);
        String reason = Objects.requireNonNull(getActivity()).getIntent().getStringExtra(Constants.INTENT_REASON);

        arrangeViews(reason);

        return view;
    }

    private void arrangeViews(String reason) {
        switch (reason) {
            case Constants.LOST_TEXT:

                break;
            case Constants.STOLEN_TEXT:

                break;
            case Constants.MALFUNCTION_BROKEN_TEXT:

                break;
        }
    }



}
