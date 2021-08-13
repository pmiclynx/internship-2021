package com.internship.tvseries.data.api;

import com.internship.tvseries.data.model.Configuration;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ConfigApi {
    @GET("configuration")
    Call<Configuration> getConfiguration();

}
