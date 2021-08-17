package com.internship.tvseries.data.api;

import com.internship.tvseries.data.model.Credentials;
import com.internship.tvseries.data.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("auth/login")
    Call<LoginResponse> login(@Body Credentials credentials);
}
