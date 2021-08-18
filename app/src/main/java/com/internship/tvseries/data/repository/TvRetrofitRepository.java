package com.internship.tvseries.data.repository;

import com.internship.tvseries.data.api.MovieApi;
import com.internship.tvseries.data.model.MoviesList;
import com.internship.tvseries.data.model.Result;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvRetrofitRepository implements TvRepository {

    private static TvRetrofitRepository instance = null;
    private final MovieApi api;

    private TvRetrofitRepository(MovieApi api) {
        this.api = api;
    }

    public static TvRetrofitRepository getInstance(MovieApi api) {
        if (instance == null)
            instance = new TvRetrofitRepository(api);
        return instance;
    }

    @Override
    public void getByCategory(String category, int page, Consumer<List<Result>> consumer) {
        Call<MoviesList> call = api.listOfMovies(category, page);
        call.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(@NotNull Call<MoviesList> call, @NotNull Response<MoviesList> response) {
                if (response.code() == 200) {
                    MoviesList movies = response.body();
                    if (movies != null) {
                        consumer.accept(movies.getResults());
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<MoviesList> call, @NotNull Throwable t) {
                consumer.accept(new ArrayList<>());
            }
        });
    }
}
