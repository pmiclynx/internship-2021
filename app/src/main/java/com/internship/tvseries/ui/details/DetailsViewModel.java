package com.internship.tvseries.ui.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.details.TvDetailsRepository;
import com.internship.tvseries.data.repository.favorites.FavoritesRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

public class DetailsViewModel extends BaseViewModel {

    private final TvDetailsRepository detailsRepository;
    private final FavoritesRepository favoritesRepository;

    private final MutableLiveData<TvDetailsResponse> _tvDetails = new MutableLiveData<>();
    public LiveData<TvDetailsResponse> tvDetails = _tvDetails;

    private final MutableLiveData<TvDetailsResponse> _favoriteTv = new MutableLiveData<>();
    public LiveData<TvDetailsResponse> favoriteTv = _favoriteTv;

    public DetailsViewModel(TvDetailsRepository detailsRepository, FavoritesRepository favoritesRepository, int id) {
        this.detailsRepository = detailsRepository;
        this.favoritesRepository = favoritesRepository;
        setTv(id);
    }

    private void setTv(int id) {
        detailsRepository.getTvDetails(id, _tvDetails::postValue);
    }

    public void checkIfAlreadyAdded(int id) {
        favoritesRepository.findById(id, _favoriteTv::postValue);
    }

    public void addFavorite(TvDetailsResponse tv) {
        favoritesRepository.insert(tv);
    }
}
