package com.quicksilver.getmydrivercard.views.step3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quicksilver.getmydrivercard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProvidePhotoFragment extends Fragment {


    public ProvidePhotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_provide_photo, container, false);
    }

}
