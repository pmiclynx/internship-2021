package com.internship.tvseries.data.repository.details;

import android.util.Log;

import com.internship.tvseries.data.api.TvDetailsApi;
import com.internship.tvseries.data.model.TvDetailsResponse;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvDetailsRetrofitRepository extends BaseDetailsRepository {


    private static TvDetailsRetrofitRepository instance;

    protected TvDetailsRetrofitRepository(TvDetailsApi tvDetailsApi) {
        super(tvDetailsApi);
    }

    public static TvDetailsRetrofitRepository getInstance(TvDetailsApi tvDetailsApi){
        if (instance == null)
            instance = new TvDetailsRetrofitRepository(tvDetailsApi);
        return instance;
    }



}
