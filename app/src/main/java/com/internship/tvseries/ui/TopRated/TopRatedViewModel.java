package com.internship.tvseries.ui.TopRated;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.data.repository.TvRepository;
import com.internship.tvseries.ui.base.BaseViewModel;
import com.internship.tvseries.utils.Constants;

import java.util.List;

public class TopRatedViewModel extends BaseViewModel {

    private final TvRepository tvRepository;

    private final MutableLiveData<List<Result>> _topRatedTvs = new MutableLiveData<>();
    public LiveData<List<Result>> topRatedTvs = _topRatedTvs;

    public TopRatedViewModel(TvRepository tvRepository) {
        this.tvRepository = tvRepository;
        getTopRated();
    }

    private void getTopRated() {
        tvRepository.getByCategory(Constants.CATEGORY_TOP_RATED, _topRatedTvs::postValue);
    }
}
