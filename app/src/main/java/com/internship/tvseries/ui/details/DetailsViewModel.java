package com.internship.tvseries.ui.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.favorites.FavoritesRoomRepository;
import com.internship.tvseries.data.repository.details.TvDetailsRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

public class DetailsViewModel extends BaseViewModel {

    private final TvDetailsRepository detailsRepository;
    private final FavoritesRoomRepository favoritesRoomRepository;

    private final MutableLiveData<TvDetailsResponse> _tvDetails = new MutableLiveData<>();

    public LiveData<TvDetailsResponse> tvDetails = _tvDetails;

    public DetailsViewModel(TvDetailsRepository detailsRepository, FavoritesRoomRepository favoritesRoomRepository, int id) {
        this.detailsRepository = detailsRepository;
        this.favoritesRoomRepository = favoritesRoomRepository;
        setTv(id);
    }

    private void setTv(int id) {
        detailsRepository.getTvDetails(id, _tvDetails::postValue);
    }

    public void checkIfAlreadyAdded(int id, DetailsActivity.FindTvListener listener) {
        new Thread(() -> {
            if (favoritesRoomRepository.findById(id) != null)
                listener.onReceived(true);
        }).start();
    }

    public void addFavorite(TvDetailsResponse tv) {
        new Thread(() -> favoritesRoomRepository.insert(tv)).start();
    }
}
