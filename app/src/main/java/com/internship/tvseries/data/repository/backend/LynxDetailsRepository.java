package com.internship.tvseries.data.repository.backend;

import android.util.Log;

import com.internship.tvseries.data.api.TvDetailsApi;
import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.details.BaseDetailsRepository;
import com.internship.tvseries.data.repository.details.TvDetailsRepository;
import com.internship.tvseries.data.repository.details.TvDetailsRetrofitRepository;

import org.jetbrains.annotations.NotNull;


import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LynxDetailsRepository extends BaseDetailsRepository {

    private static LynxDetailsRepository instance;

    protected LynxDetailsRepository(TvDetailsApi tvDetailsApi) {
        super(tvDetailsApi);
    }

    public static LynxDetailsRepository getInstance(TvDetailsApi tvDetailsApi){
        if (instance == null)
            instance = new LynxDetailsRepository(tvDetailsApi);
        return instance;
    }
}


