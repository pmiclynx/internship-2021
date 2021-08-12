package com.internship.tvseries.ui.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.TvRepository;
import com.internship.tvseries.data.repository.favorites.FavoritesRepository;
import com.internship.tvseries.ui.base.BaseViewModel;
import com.internship.tvseries.utils.Constants;

import java.util.List;
import java.util.function.Consumer;

public class FavoritesViewModel extends BaseViewModel {
    private final FavoritesRepository favoritesRepository;

    private MutableLiveData<List<TvDetailsResponse>> _favTvs = new MutableLiveData<>();
    public LiveData<List<TvDetailsResponse>> favTvs = _favTvs;

    public FavoritesViewModel(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
        getFavorites();
    }

    public void getFavorites(){
        favoritesRepository.getAll(new Consumer<List<TvDetailsResponse>>() {
            @Override
            public void accept(List<TvDetailsResponse> tvDetailsResponses) {
                _favTvs.postValue(tvDetailsResponses);
            }
        });
    }

}
