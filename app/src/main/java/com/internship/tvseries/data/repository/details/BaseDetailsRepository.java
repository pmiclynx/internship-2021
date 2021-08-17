package com.internship.tvseries.data.repository.details;

import com.internship.tvseries.data.api.TvDetailsApi;
import com.internship.tvseries.data.model.TvDetailsResponse;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseDetailsRepository implements TvDetailsRepository {


    private final TvDetailsApi tvDetailsApi;

    protected BaseDetailsRepository(TvDetailsApi tvDetailsApi) {
        this.tvDetailsApi = tvDetailsApi;
    }

    public void getTvDetails(int id, Consumer<TvDetailsResponse> consumer) {
        Call<TvDetailsResponse> responseCall = tvDetailsApi.getMovieDetails(id);
        responseCall.enqueue(new Callback<TvDetailsResponse>() {
            @Override
            public void onResponse(@NotNull Call<TvDetailsResponse> call, @NotNull Response<TvDetailsResponse> response) {
                if (response.code() == 200) {
                    TvDetailsResponse tv = response.body();
                    if (tv != null)
                        consumer.accept(tv);
                } else
                    consumer.accept(null);
            }

            @Override
            public void onFailure(@NotNull Call<TvDetailsResponse> call, @NotNull Throwable t) {
                consumer.accept(null);
            }
        });

    }
}
