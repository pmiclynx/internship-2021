package com.internship.tvseries.ui.TopRated;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.internship.tvseries.data.repository.TvRepository;

import org.jetbrains.annotations.NotNull;

public class TopRatedViewModelFactory implements ViewModelProvider.Factory {

    private final TvRepository tvRepository;

    public TopRatedViewModelFactory(TvRepository tvRepository) {
        this.tvRepository = tvRepository;
    }

    @NonNull
    @NotNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TopRatedViewModel.class))
            return (T) new TopRatedViewModel(tvRepository);
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}
