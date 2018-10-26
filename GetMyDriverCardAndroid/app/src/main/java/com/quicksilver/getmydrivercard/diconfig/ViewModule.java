package com.quicksilver.getmydrivercard.diconfig;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.quicksilver.getmydrivercard.views.requests.RequestsAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {
    @Provides
    public RecyclerView.Adapter<RequestsAdapter.ApplicationViewHolder> requestsAdapter(Context context) {
        return new RequestsAdapter();
    }
}
