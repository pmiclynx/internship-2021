package com.internship.tvseries.data.repository.backend;

import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.details.TvDetailsRepository;

import java.util.ArrayList;
import java.util.function.Consumer;

public class BackendDetailsRepository implements TvDetailsRepository {

    @Override
    public void getTvDetails(int id, Consumer<TvDetailsResponse> consumer) {

        consumer.accept(null);
    }
}
