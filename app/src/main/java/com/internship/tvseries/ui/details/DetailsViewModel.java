package com.internship.tvseries.ui.details;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.FavoritesRepository;
import com.internship.tvseries.data.repository.TvDetailsRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsViewModel extends BaseViewModel {

    private final TvDetailsRepository detailsRepository;
    private final FavoritesRepository favoritesRepository;

    private final MutableLiveData<TvDetailsResponse> _tvDetails = new MutableLiveData<>();

    public LiveData<TvDetailsResponse> tvDetails = _tvDetails;

    public DetailsViewModel(TvDetailsRepository detailsRepository, FavoritesRepository favoritesRepository, int id) {
        this.detailsRepository = detailsRepository;
        this.favoritesRepository = favoritesRepository;
        setTv(id);
    }

    private void setTv(int id) {
        Call<TvDetailsResponse> responseCall = detailsRepository.getTvDetails(id);
        responseCall.enqueue(new Callback<TvDetailsResponse>() {
            @Override
            public void onResponse(@NotNull Call<TvDetailsResponse> call, @NotNull Response<TvDetailsResponse> response) {
                if (response.code() == 200) {
                    TvDetailsResponse tv = response.body();
                    if (tv != null)
                        _tvDetails.postValue(tv);
                } else
                    Log.i("DetailsViewModel", response.message());
            }

            @Override
            public void onFailure(@NotNull Call<TvDetailsResponse> call, @NotNull Throwable t) {
                Log.e("DetailsViewModel", t.getMessage());
            }
        });
    }

    public void checkIfAlreadyAdded(int id, DetailsActivity.FindTvListener listener) {
        new Thread(() -> {
            if (favoritesRepository.findById(id) != null)
                listener.onReceived(true);
        }).start();
    }

    public void addFavorite(TvDetailsResponse tv) {
        new Thread(() -> favoritesRepository.insert(tv)).start();
    }
}
