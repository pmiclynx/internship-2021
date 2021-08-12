package com.internship.tvseries.ui.favorites;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.internship.tvseries.data.repository.favorites.FavoritesRepository;

public class FavoritesViewModelFactory implements ViewModelProvider.Factory {
    private final FavoritesRepository favoritesRepository;

    public FavoritesViewModelFactory(FavoritesRepository favoritesRepository){
        this.favoritesRepository = favoritesRepository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FavoritesViewModel.class))
            return (T) new FavoritesViewModel(favoritesRepository);
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}
