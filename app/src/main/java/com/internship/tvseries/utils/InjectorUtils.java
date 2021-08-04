package com.internship.tvseries.utils;

import android.app.Application;

import com.internship.tvseries.data.api.ApiClient;
import com.internship.tvseries.data.api.TvDetailsApi;
import com.internship.tvseries.data.repository.TvDetailsRepository;
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

    public DetailsViewModelFactory provideDetailsViewModelFactory(int id) {
        TvDetailsRepository repository = TvDetailsRepository.getInstance(ApiClient.getTvDetailsApi());
        return new DetailsViewModelFactory(repository, id);
    }
}
