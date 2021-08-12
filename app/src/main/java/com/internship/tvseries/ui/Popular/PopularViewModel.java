package com.internship.tvseries.ui.Popular;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.data.repository.TvRepository;
import com.internship.tvseries.ui.base.BaseViewModel;
import com.internship.tvseries.utils.Constants;

import java.util.List;

public class PopularViewModel extends BaseViewModel {
    private final TvRepository tvRepository;

    private final MutableLiveData<List<Result>> _popularTvs = new MutableLiveData<>();
    public LiveData<List<Result>> popularTvs = _popularTvs;

    public PopularViewModel(TvRepository tvRepository) {
        this.tvRepository = tvRepository;
        getPopular();
    }

    private void getPopular() {
        tvRepository.getByCategory(Constants.CATEGORY_POPULAR, _popularTvs::postValue);

    }

}
