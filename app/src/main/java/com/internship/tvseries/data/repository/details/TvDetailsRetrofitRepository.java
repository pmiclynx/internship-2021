package com.internship.tvseries.data.repository.details;

import android.util.Log;

import com.internship.tvseries.data.api.TvDetailsApi;
import com.internship.tvseries.data.model.TvDetailsResponse;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvDetailsRetrofitRepository implements TvDetailsRepository{

    private static TvDetailsRetrofitRepository instance = null;

    private final TvDetailsApi tvDetailsApi;

    private TvDetailsRetrofitRepository(TvDetailsApi tvDetailsApi) {
        this.tvDetailsApi = tvDetailsApi;
    }

    public static TvDetailsRetrofitRepository getInstance(TvDetailsApi tvDetailsApi) {
        if (instance == null)
            instance = new TvDetailsRetrofitRepository(tvDetailsApi);

        return instance;
    }


    @Override
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
                    Log.e("DetailsRepository", response.message());
            }

            @Override
            public void onFailure(@NotNull Call<TvDetailsResponse> call, @NotNull Throwable t) {
                Log.e("DetailsRepository", t.getMessage());
            }
        });
    }
}
