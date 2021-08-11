package com.internship.tvseries.ui.TopRated;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.MoviesList;
import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.data.repository.TvRepository;
import com.internship.tvseries.ui.base.BaseViewModel;
import com.internship.tvseries.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedViewModel extends BaseViewModel {

    private final TvRepository tvRepository;

    private final MutableLiveData<List<Result>> _topRatedTvs = new MutableLiveData<>();
    public LiveData<List<Result>> topRatedTvs = _topRatedTvs;

    public TopRatedViewModel(TvRepository tvRepository) {
        this.tvRepository = tvRepository;
        getTopRated();
    }

    private void getTopRated() {
        Call<MoviesList> call = tvRepository.getTvByCategory(Constants.CATEGORY_TOP_RATED);
        call.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(@NotNull Call<MoviesList> call, @NotNull Response<MoviesList> response) {
                if (response.code() == 200) {
                    MoviesList movies = response.body();
                    if (movies != null) {
                        _topRatedTvs.postValue(new ArrayList<>(movies.getResults()));
                    }
                } else
                    Log.e("TopRatedViewModel", response.message());
            }

            @Override
            public void onFailure(@NotNull Call<MoviesList> call, @NotNull Throwable t) {
                Log.e("TopRatedViewModel", t.getMessage());
            }
        });
    }
}
