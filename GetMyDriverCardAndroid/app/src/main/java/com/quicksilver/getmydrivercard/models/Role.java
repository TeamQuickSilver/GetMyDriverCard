package com.quicksilver.getmydrivercard.models;

import java.io.Serializable;

public class Role implements Serializable {
    private String authority;

    public Role() {

    }

    public Role(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
