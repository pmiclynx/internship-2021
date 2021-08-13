package com.internship.tvseries.data.repository.backend;

import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.data.repository.TvRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LynxTopRatedRepository implements TvRepository {
    @Override
    public void getByCategory(String category, Consumer<List<Result>> consumer) {


        consumer.accept(new ArrayList<>());
    }
}
