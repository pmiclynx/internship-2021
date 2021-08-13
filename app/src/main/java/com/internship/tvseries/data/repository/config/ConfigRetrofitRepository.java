package com.internship.tvseries.data.repository.config;

import com.internship.tvseries.data.api.ConfigApi;
import com.internship.tvseries.data.model.Configuration;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfigRetrofitRepository implements ConfigRepository {

    private static ConfigRetrofitRepository instance = null;
    private final ConfigApi configApi;

    private ConfigRetrofitRepository(ConfigApi configApi) {
        this.configApi = configApi;
    }

    public static ConfigRetrofitRepository getInstance(ConfigApi configApi) {
        if (instance == null)
            instance = new ConfigRetrofitRepository(configApi);
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
