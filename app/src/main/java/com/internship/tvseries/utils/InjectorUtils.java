package com.internship.tvseries.utils;

import android.content.Context;

import com.internship.tvseries.data.api.ApiClient;
import com.internship.tvseries.data.repository.FavoritesRepository;
import com.internship.tvseries.data.repository.TvRetrofitRepository;
import com.internship.tvseries.data.repository.details.TvDetailsRepository;
import com.internship.tvseries.data.repository.details.TvDetailsRetrofitRepository;
import com.internship.tvseries.data.repository.auth.FirebaseAuthRepository;
import com.internship.tvseries.data.repository.db.FavoritesDatabase;
import com.internship.tvseries.login_screen.register.RegisterViewModelFactory;
import com.internship.tvseries.ui.Popular.PopularViewModelFactory;
import com.internship.tvseries.ui.TopRated.TopRatedViewModelFactory;
import com.internship.tvseries.ui.details.DetailsViewModelFactory;

public class InjectorUtils {

    private static InjectorUtils instance = null;

    private InjectorUtils() {
    }

    public static InjectorUtils getInstance() {
        if (instance == null)
            instance = new InjectorUtils();
        return instance;
    }

    public DetailsViewModelFactory provideDetailsViewModelFactory(int id, Context context) {
        TvDetailsRepository tvDetailsRepository = TvDetailsRetrofitRepository.getInstance(ApiClient.getTvDetailsApi());
        FavoritesRepository favoritesRepository= FavoritesRepository.getInstance(FavoritesDatabase.getInstance(context).favoritesDao());
        return new DetailsViewModelFactory(tvDetailsRepository, favoritesRepository, id);
    }

    public RegisterViewModelFactory provideRegisterViewModelFactory() {
        return new RegisterViewModelFactory(FirebaseAuthRepository.getInstance());
    }

    public TopRatedViewModelFactory provideTopRatedViewModelFactory() {
        return new TopRatedViewModelFactory(TvRetrofitRepository.getInstance(ApiClient.getMovieApi()));
    }

    public PopularViewModelFactory providePopularViewModelFactory() {
        return new PopularViewModelFactory(TvRetrofitRepository.getInstance(ApiClient.getMovieApi()));
    }
}
