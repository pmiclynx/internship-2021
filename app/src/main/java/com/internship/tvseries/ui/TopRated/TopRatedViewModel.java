package com.internship.tvseries.ui.TopRated;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.data.repository.TvRepository;
import com.internship.tvseries.ui.base.BaseViewModel;
import com.internship.tvseries.utils.Constants;

import java.util.List;
import java.util.function.Consumer;

public class TopRatedViewModel extends BaseViewModel {

    private final TvRepository tvRepository;
    private final TvRepository backendTopRatedRepository;

    private final MutableLiveData<List<Result>> _topRatedTvs = new MutableLiveData<>();
    public LiveData<List<Result>> topRatedTvs = _topRatedTvs;

    public TopRatedViewModel(TvRepository tvRepository, TvRepository backendTopRatedRepository) {
        this.tvRepository = tvRepository;
        this.backendTopRatedRepository=backendTopRatedRepository;
        getTopRated();
    }

    private void getTopRated() {
        backendTopRatedRepository.getByCategory(Constants.CATEGORY_TOP_RATED, new Consumer<List<Result>>() {
            @Override
            public void accept(List<Result> results) {
                if(results.isEmpty()){
                    tvRepository.getByCategory(Constants.CATEGORY_TOP_RATED, new Consumer<List<Result>>() {
                        @Override
                        public void accept(List<Result> results) {
                            _topRatedTvs.postValue(results);
                        }
                    });
                }else{
                    _topRatedTvs.postValue(results);
                }
            }
        });
    }
}
