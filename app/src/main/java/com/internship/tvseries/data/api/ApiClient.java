package com.internship.tvseries.data.api;

import com.internship.tvseries.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(chain -> {
                HttpUrl url = chain.request()
                        .url()
                        .newBuilder()
                        .addQueryParameter("api_key", Constants.API_KEY)
                        .build();

                Request request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build();
                return chain.proceed(request);
            })
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();

    private static final Retrofit retrofit = new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final TvDetailsApi tvDetailsApi = retrofit.create(TvDetailsApi.class);
    public static TvDetailsApi getTvDetailsApi() {
        return tvDetailsApi;
    }

    /*private static final MovieApi movieApi=retrofit.create(MovieApi.class);
    public static MovieApi getMovieApi(){return movieApi;}*/

}
