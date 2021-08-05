package com.internship.tvseries.data.repository;

import com.internship.tvseries.data.api.TvDetailsApi;
import com.internship.tvseries.data.model.TvDetailsResponse;

import retrofit2.Call;

public class TvDetailsRepository {

    private static TvDetailsRepository instance = null;

    private final TvDetailsApi tvDetailsApi;

    private TvDetailsRepository(TvDetailsApi tvDetailsApi) {
        this.tvDetailsApi = tvDetailsApi;
    }

    public static TvDetailsRepository getInstance(TvDetailsApi tvDetailsApi) {
        if (instance == null)
            instance = new TvDetailsRepository(tvDetailsApi);

        return instance;
    }

    public Call<TvDetailsResponse> getTvDetails(int id) {
        return tvDetailsApi.getMovieDetails(id);
    }

}
