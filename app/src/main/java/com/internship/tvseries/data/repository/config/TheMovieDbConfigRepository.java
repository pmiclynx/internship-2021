package com.internship.tvseries.data.repository.config;

import android.util.Log;

import com.internship.tvseries.data.api.ConfigApi;
import com.internship.tvseries.data.model.Configuration;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TheMovieDbConfigRepository implements ConfigRepository {

    private static TheMovieDbConfigRepository instance = null;
    private final ConfigApi configApi;

    private TheMovieDbConfigRepository(ConfigApi configApi) {
        this.configApi = configApi;
    }

    public static TheMovieDbConfigRepository getInstance(ConfigApi configApi) {
        synchronized (TheMovieDbConfigRepository.class) {
            if (instance == null) {
                instance = new TheMovieDbConfigRepository(configApi);
            }
        }
        return instance;
    }

    @Override
    public void getConfig(Consumer<Configuration> consumer) {
        configApi.getConfiguration().enqueue(new Callback<Configuration>() {
            @Override
            public void onResponse(@NotNull Call<Configuration> call, @NotNull Response<Configuration> response) {
                consumer.accept(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<Configuration> call, @NotNull Throwable t) {
                consumer.accept(null);
            }
        });
    }
}
