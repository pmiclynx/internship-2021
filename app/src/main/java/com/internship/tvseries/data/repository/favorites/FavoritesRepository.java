package com.internship.tvseries.data.repository.favorites;

import com.internship.tvseries.data.model.TvDetailsResponse;

import java.util.List;
import java.util.function.Consumer;

public interface FavoritesRepository {
    void insert(TvDetailsResponse result);
    void delete(TvDetailsResponse result);
    void getAll(Consumer<List<TvDetailsResponse>> consumer);
    void findById(int id, Consumer<TvDetailsResponse> consumer);
}
