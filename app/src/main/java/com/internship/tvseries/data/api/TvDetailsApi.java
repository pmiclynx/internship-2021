package com.internship.tvseries.data.api;

import com.internship.tvseries.data.model.TvDetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TvDetailsApi {

    //https://api.themoviedb.org/3/tv/84958?api_key=3133b12095185ad24d14551d402e8a5c
    @GET("tv/{tv_id}")
    Call<TvDetailsResponse> getMovieDetails(@Path("tv_id") int tvId);
}
