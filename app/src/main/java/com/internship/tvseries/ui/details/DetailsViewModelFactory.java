package com.internship.tvseries.ui.details;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.internship.tvseries.data.repository.favorites.FavoritesRoomRepository;
import com.internship.tvseries.data.repository.details.TvDetailsRepository;

import org.jetbrains.annotations.NotNull;

public class DetailsViewModelFactory implements ViewModelProvider.Factory {

    private final TvDetailsRepository detailsRepository;
    private final FavoritesRoomRepository favoritesRoomRepository;
    private final int id;

    public DetailsViewModelFactory(TvDetailsRepository detailsRepository, FavoritesRoomRepository favoritesRoomRepository, int id) {
        this.detailsRepository = detailsRepository;
        this.favoritesRoomRepository = favoritesRoomRepository;
        this.id = id;
    }

    @NonNull
    @NotNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailsViewModel.class))
            return (T) new DetailsViewModel(detailsRepository, favoritesRoomRepository, id);

        throw new IllegalArgumentException("Unknown View Model Class");
    }
}
