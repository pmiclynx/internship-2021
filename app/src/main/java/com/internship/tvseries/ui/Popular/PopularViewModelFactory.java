package com.internship.tvseries.ui.Popular;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.internship.tvseries.data.repository.TvRepository;

public class PopularViewModelFactory implements ViewModelProvider.Factory {

    private final TvRepository tvRepository;
    private final TvRepository backendPopularRepository;
    public PopularViewModelFactory(TvRepository tvRepository, TvRepository backendPopularRepository) {
        this.tvRepository = tvRepository;
        this.backendPopularRepository=backendPopularRepository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PopularViewModel.class))
            return (T) new PopularViewModel(tvRepository,backendPopularRepository);
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}
