package com.quicksilver.getmydrivercard.views.step4;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.async.base.SchedulerProvider;
import com.quicksilver.getmydrivercard.services.ApplicationService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

public class Step4Presenter implements Step4Contracts.Presenter {
    private final ApplicationService mApplicationsService;
    private final SchedulerProvider mSchedulerProvider;
    private Step4Contracts.View mView;

    @Inject
    public Step4Presenter(ApplicationService applicationService, SchedulerProvider schedulerProvider) {
        this.mApplicationsService = applicationService;
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(Step4Contracts.View view) {
        mView = view;
    }

    @Override
    public byte[] convertUriIntoByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        byte[] buffer = new byte[Constants.BUFFER_SIZE];

        int len = 0;
        while((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        return byteBuffer.toByteArray();
    }
}
