package com.quicksilver.getmydrivercard.async;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler background();

    Scheduler ui();

}
