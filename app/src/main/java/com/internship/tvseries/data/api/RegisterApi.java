package com.internship.tvseries.data.api;

import com.internship.tvseries.data.model.RegisterRequest;
import com.internship.tvseries.data.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterApi {
    @POST("auth/register")
    @FormUrlEncoded
    Call<RegisterResponse> registerUser(
            @Body RegisterRequest registerR
    );

}
