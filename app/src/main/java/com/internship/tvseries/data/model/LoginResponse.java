package com.internship.tvseries.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("user")
    private User user;


    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public User getUser() {
        return user;
    }
}
