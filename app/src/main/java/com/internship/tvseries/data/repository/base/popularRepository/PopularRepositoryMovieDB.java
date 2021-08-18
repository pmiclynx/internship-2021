package com.internship.tvseries.data.repository.base.popularRepository;

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

public class PopularRepositoryMovieDB extends PopularRepository {

    private static PopularRepositoryMovieDB instance;

    public PopularRepositoryMovieDB(MovieApi api) {
        super(api);
    }

    public static PopularRepositoryMovieDB getInstance(MovieApi api) {
        if (instance == null)
            instance = new PopularRepositoryMovieDB(api);
        return instance;
    }

}
