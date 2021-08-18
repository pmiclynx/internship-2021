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
    private final TvRepository lynxTopRatedRepository;

    private final MutableLiveData<List<Result>> _topRatedTvs = new MutableLiveData<>();
    public LiveData<List<Result>> topRatedTvs = _topRatedTvs;

    private final MutableLiveData<List<Result>> _newTopRatedTvs = new MutableLiveData<>();
    public LiveData<List<Result>> newTopRatedTvs = _newTopRatedTvs;

    public TopRatedViewModel(TvRepository tvRepository, TvRepository lynxTopRatedRepository) {
        this.tvRepository = tvRepository;
        this.lynxTopRatedRepository = lynxTopRatedRepository;
        getTopRated();
    }

    private void getTopRated() {
        lynxTopRatedRepository.getByCategory(Constants.CATEGORY_TOP_RATED, 1, new Consumer<List<Result>>() {
            @Override
            public void accept(List<Result> results) {
                if(results.isEmpty()){
                    tvRepository.getByCategory(Constants.CATEGORY_TOP_RATED, 1, new Consumer<List<Result>>() {
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

    public void nextPage(int page) {
        lynxTopRatedRepository.getByCategory(Constants.CATEGORY_POPULAR, page, new Consumer<List<Result>>() {
            @Override
            public void accept(List<Result> results) {
                if (results == null) {
                    tvRepository.getByCategory(Constants.CATEGORY_POPULAR, page, new Consumer<List<Result>>() {
                        @Override
                        public void accept(List<Result> results) {
                            _newTopRatedTvs.postValue(results);
                        }
                    });
                } else {
//                    if (!results.isEmpty())
                    _newTopRatedTvs.postValue(results);
                }
            }
        });
    }
}
