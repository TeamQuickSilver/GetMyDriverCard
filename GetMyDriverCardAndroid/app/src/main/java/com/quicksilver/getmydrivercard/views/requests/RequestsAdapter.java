package com.quicksilver.getmydrivercard.views.requests;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.models.Application;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RequestsAdapter extends RecyclerView.Adapter<RequestsAdapter.ApplicationViewHolder> {
    private List<Application> mApplications;
    private onApplicationClickListener mOnApplicationClickListener;

    @Inject
    public RequestsAdapter() {
        mApplications = new ArrayList<>();
    }

    @NonNull
    @Override
    public ApplicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.application_item, parent, false);

        int height = parent.getMeasuredHeight() / 5;

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
        view.setMinimumHeight(height);
        return new ApplicationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationViewHolder holder, int position) {
        holder.setOnApplicationClickListener(mOnApplicationClickListener);
        holder.bind(mApplications.get(position));
    }

    @Override
    public int getItemCount() {
        return mApplications.size();
    }

    public Application getItem(int position) {
        return mApplications.get(position);
    }

    public void clear() {
        mApplications.clear();
    }

    public void addAll(List<Application> applications) {
        mApplications.addAll(applications);
    }

    public void setOnApplicationClickListener(onApplicationClickListener mOnApplicationClickListener) {
        this.mOnApplicationClickListener = mOnApplicationClickListener;
    }

    public static class ApplicationViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_date_of_submission)
        TextView mDateOfSubmission;

        @BindView(R.id.tv_identity_number)
        TextView mApplicationStatus;

        private Application mApplication;
        private onApplicationClickListener mOnClickListener;

        public ApplicationViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Application application) {
            mDateOfSubmission.setText(application.getDateOfSubmission().toString());
            mApplicationStatus.setText(application.getPerson().getIdentityCard().getPersonalNumber() + "");

            mApplication = application;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mApplication);
        }

        public void setOnApplicationClickListener(onApplicationClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface onApplicationClickListener {
        void onClick(Application application);
    }
}
