package com.internship.tvseries.data.repository;

import com.internship.tvseries.data.model.Result;

import java.util.List;
import java.util.function.Consumer;

public interface TvRepository {
    void getByCategory(String category, Consumer<List<Result>> consumer);
}
