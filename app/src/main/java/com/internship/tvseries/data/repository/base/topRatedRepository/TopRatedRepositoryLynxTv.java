package com.internship.tvseries.data.repository.base.topRatedRepository;

import com.internship.tvseries.data.api.MovieApi;
import com.internship.tvseries.data.model.MoviesList;
import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.data.repository.base.BaseTvRepository;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedRepositoryLynxTv extends BaseTvRepository {

    private static TopRatedRepositoryLynxTv instance;

    protected TopRatedRepositoryLynxTv(MovieApi api) {
        super(api);
    }


    public static TopRatedRepositoryLynxTv getInstance(MovieApi api) {
        if (instance == null)
            instance = new TopRatedRepositoryLynxTv(api);
        return instance;
    }

}


