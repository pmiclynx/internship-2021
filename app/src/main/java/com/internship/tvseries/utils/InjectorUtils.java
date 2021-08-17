package com.internship.tvseries.utils;

import android.content.Context;

import com.internship.tvseries.data.api.LynxApiClient;
import com.internship.tvseries.data.api.TheMovieDBApiClient;
import com.internship.tvseries.data.repository.auth.FirebaseLoginRepository;
import com.internship.tvseries.data.repository.TvRetrofitRepository;
import com.internship.tvseries.data.repository.auth.FirebaseRegisterRepository;
import com.internship.tvseries.data.repository.auth.LynxLoginRepository;
import com.internship.tvseries.data.repository.auth.LynxRegisterRepository;
import com.internship.tvseries.data.repository.backend.LynxDetailsRepository;
import com.internship.tvseries.data.repository.backend.LynxPopularRepository;
import com.internship.tvseries.data.repository.backend.LynxTopRatedRepository;
import com.internship.tvseries.data.repository.db.FavoritesDatabase;
import com.internship.tvseries.data.repository.details.TvDetailsRepository;
import com.internship.tvseries.data.repository.details.TvDetailsRetrofitRepository;
import com.internship.tvseries.data.repository.favorites.FavoritesRepository;
import com.internship.tvseries.data.repository.favorites.FavoritesRoomRepository;
import com.internship.tvseries.login_screen.login.LoginViewModelFactory;
import com.internship.tvseries.login_screen.register.RegisterViewModelFactory;
import com.internship.tvseries.ui.Popular.PopularViewModelFactory;
import com.internship.tvseries.ui.TopRated.TopRatedViewModelFactory;
import com.internship.tvseries.ui.details.DetailsViewModelFactory;
import com.internship.tvseries.ui.favorites.FavoritesViewModelFactory;

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
        TvDetailsRepository tvDetailsRepository = TvDetailsRetrofitRepository.getInstance(TheMovieDBApiClient.getTvDetailsApi());
        FavoritesRepository favoritesRoomRepository = FavoritesRoomRepository.getInstance(FavoritesDatabase.getInstance(context).favoritesDao());
        return new DetailsViewModelFactory(tvDetailsRepository, favoritesRoomRepository, id, LynxDetailsRepository.getInstance(LynxApiClient.getTvDetailsApi()));
    }

    public RegisterViewModelFactory provideRegisterViewModelFactory() {
        return new RegisterViewModelFactory(FirebaseRegisterRepository.getInstance(), LynxRegisterRepository.getInstance(LynxApiClient.getRegisterApi()));
    }

    public TopRatedViewModelFactory provideTopRatedViewModelFactory() {
        return new TopRatedViewModelFactory(TvRetrofitRepository.getInstance(TheMovieDBApiClient.getMovieApi()), LynxTopRatedRepository.getInstance(LynxApiClient.getMovieApi()));
    }

    public PopularViewModelFactory providePopularViewModelFactory() {
        return new PopularViewModelFactory(TvRetrofitRepository.getInstance(TheMovieDBApiClient.getMovieApi()), LynxPopularRepository.getInstance(LynxApiClient.getMovieApi()));
    }

    public FavoritesViewModelFactory provideFavoritesViewModelFactory(Context context) {
        return new FavoritesViewModelFactory(FavoritesRoomRepository.getInstance(FavoritesDatabase.getInstance(context).favoritesDao()));
    }

    public LoginViewModelFactory provideLoginViewModelFactory() {
        return new LoginViewModelFactory(FirebaseLoginRepository.getInstance(), LynxLoginRepository.getInstance(LynxApiClient.getLoginApi()));
    }
}
