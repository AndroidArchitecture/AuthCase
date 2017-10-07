package com.matsyuk.authcase.data.common_network;

import android.support.annotation.NonNull;

/**
 * @author e.matsyuk
 */
public class RequestTokenModel {

    private String pinCode;

    public RequestTokenModel(@NonNull String pinCode) {
        this.pinCode = pinCode;
    }

}
