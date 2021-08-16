package com.internship.tvseries.ui.Popular;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.data.repository.TvRepository;
import com.internship.tvseries.ui.base.BaseViewModel;
import com.internship.tvseries.utils.Constants;

import java.util.List;
import java.util.function.Consumer;

public class PopularViewModel extends BaseViewModel {
    private final TvRepository tvRepository;
    private final TvRepository lynxPopularRepository;

    private final MutableLiveData<List<Result>> _popularTvs = new MutableLiveData<>();
    public LiveData<List<Result>> popularTvs = _popularTvs;

    public PopularViewModel(TvRepository tvRepository, TvRepository lynxPopularRepository) {
        this.tvRepository = tvRepository;
        this.lynxPopularRepository = lynxPopularRepository;
        getPopular();
    }

    private void getPopular() {
        lynxPopularRepository.getByCategory(Constants.CATEGORY_POPULAR, new Consumer<List<Result>>() {
            @Override
            public void accept(List<Result> results) {
                if (results.isEmpty()) {
                    tvRepository.getByCategory(Constants.CATEGORY_POPULAR, new Consumer<List<Result>>() {
                        @Override
                        public void accept(List<Result> results) {
                            _popularTvs.postValue(results);
                        }
                    });
                } else {
                    _popularTvs.postValue(results);
                }
            }
        });
    }
}
