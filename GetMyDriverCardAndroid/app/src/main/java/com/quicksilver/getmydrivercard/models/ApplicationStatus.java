package com.quicksilver.getmydrivercard.models;

import com.google.gson.annotations.SerializedName;

public enum ApplicationStatus {
    @SerializedName("11")
    NEW,
    @SerializedName("12")
    APPROVED,
    @SerializedName("13")
    REJECTED,
    @SerializedName("14")
    INPROGRESS,
    @SerializedName("15")
    COMPLETED;

    ApplicationStatus() {

    }
}
