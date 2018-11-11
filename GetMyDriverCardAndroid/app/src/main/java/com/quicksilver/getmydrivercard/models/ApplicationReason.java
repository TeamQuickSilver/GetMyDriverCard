package com.quicksilver.getmydrivercard.models;

import com.google.gson.annotations.SerializedName;

public enum ApplicationReason {
    @SerializedName("0")
    NEW,
    @SerializedName("1")
    LOST,
    @SerializedName("2")
    STOLEN,
    @SerializedName("3")
    MALFUNCTION_BROKEN,
    @SerializedName("4")
    NAME_CHANGE,
    @SerializedName("5")
    ADDRESS_CHANGE,
    @SerializedName("6")
    PHOTO_CHANGE,
    @SerializedName("7")
    DRIVING_LICENSE_CHANGE,
    @SerializedName("8")
    EXCHANGE,
    @SerializedName("9")
    RENEW,
    @SerializedName("10")
    WITHDRAWN;

    ApplicationReason() {

    }
}
