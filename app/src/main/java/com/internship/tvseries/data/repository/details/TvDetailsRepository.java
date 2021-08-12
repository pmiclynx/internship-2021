package com.internship.tvseries.data.repository.details;

import com.internship.tvseries.data.model.TvDetailsResponse;

import java.util.function.Consumer;

public interface TvDetailsRepository {
    void getTvDetails(int id, Consumer<TvDetailsResponse> consumer);
}
