package com.internship.tvseries.utils;

import com.internship.tvseries.data.api.ApiClient;
import com.internship.tvseries.data.model.Configuration;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class Constants {
    public final static String BASE_URL = "https://api.themoviedb.org/3/";
    public final static String API_KEY = "3133b12095185ad24d14551d402e8a5c";
    public static String IMAGE_BASE_URL;

    public static void setImageBaseUrl() {
        ApiClient.getConfigApi().getConfiguration().enqueue(new Callback<Configuration>() {
            @Override
            public void onResponse(@NotNull Call<Configuration> call, @NotNull Response<Configuration> response) {
                IMAGE_BASE_URL = response.body().getImages().getSecureBaseUrl() + response.body().getImages().getPosterSizes().get(5);
            }

            @Override
            public void onFailure(Call<Configuration> call, Throwable t) {
            }
        });
    }
}
