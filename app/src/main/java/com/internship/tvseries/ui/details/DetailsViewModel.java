package com.internship.tvseries.ui.details;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.TvDetailsRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsViewModel extends BaseViewModel {

    private final TvDetailsRepository detailsRepository;

    private final MutableLiveData<TvDetailsResponse> _tvDetails = new MutableLiveData<>();

    public LiveData<TvDetailsResponse> tvDetails = new LiveData<TvDetailsResponse>() {
        @Nullable
        @org.jetbrains.annotations.Nullable
        @Override
        public TvDetailsResponse getValue() {
            return _tvDetails.getValue();
        }

        @Override
        public void observe(@NonNull @NotNull LifecycleOwner owner, @NonNull @NotNull Observer<? super TvDetailsResponse> observer) {
            _tvDetails.observe(owner, observer);
        }
    };

    public DetailsViewModel(TvDetailsRepository detailsRepository, int id) {
        this.detailsRepository = detailsRepository;
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
}
