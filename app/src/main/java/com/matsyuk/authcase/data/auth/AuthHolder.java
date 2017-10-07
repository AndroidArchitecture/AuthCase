package com.matsyuk.authcase.data.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author e.matsyuk
 */
public class AuthHolder {

    @Nullable
    private String token;

    public void setToken(@NonNull String token) {
        this.token = token;
    }

    @Nullable
    public String getToken() {
        return token;
    }

}
