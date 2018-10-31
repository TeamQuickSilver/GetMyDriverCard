package com.quicksilver.getmydrivercard.views.step2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.quicksilver.getmydrivercard.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RenewCardFragment extends Fragment {
    @BindView(R.id.btn_next)
    Button mButtonNext;

    @Inject
    public RenewCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_renew_card, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.btn_next)
    public void onClick(View view) {
        // Navigate to Step 3
    }
}
