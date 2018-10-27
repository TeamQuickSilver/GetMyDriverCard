package com.quicksilver.getmydrivercard.views.requests;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationStatus;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequestsFragment extends Fragment implements RequestsContracts.View, RequestsAdapter.onApplicationClickListener {
    @Inject
    RequestsAdapter mRequestsAdapter;

    @BindView(R.id.rv_applications)
    RecyclerView mRecyclerView;
    private GridLayoutManager mApplicationViewLayoutManager;
    private RequestsContracts.Presenter mPresenter;
    private RequestsContracts.Navigator mNavigator;

    @Inject
    public RequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_requests, container, false);

        ButterKnife.bind(this, view);
        mRequestsAdapter.setOnApplicationClickListener(this);
        mRecyclerView.setAdapter(mRequestsAdapter);

        mApplicationViewLayoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(mApplicationViewLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadApplicationsByStatus(ApplicationStatus.NEW);
    }

    @Override
    public void onClick(Application application) {
        mNavigator.navigateToDetails(application);
    }

    @Override
    public void setPresenter(RequestsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(RequestsContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void loadApplications(List<Application> newApplications) {
        mRequestsAdapter.clear();
        mRequestsAdapter.addAll(newApplications);
        mRequestsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
