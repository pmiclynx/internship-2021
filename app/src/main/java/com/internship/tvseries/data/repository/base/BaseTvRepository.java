package com.internship.tvseries.data.repository.base;

import com.internship.tvseries.data.api.MovieApi;
import com.internship.tvseries.data.model.MoviesList;
import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.data.repository.TvRepository;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseTvRepository implements TvRepository {

    public final MovieApi api;

    public BaseTvRepository(MovieApi api) {
        this.api = api;
    }


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
        public void onFailure(Call<MoviesList> call, Throwable t) {
            consumer.accept(new ArrayList<>());
        }
    });
}
}
