package com.internship.tvseries.utils;

import com.internship.tvseries.data.api.ApiClient;
import com.internship.tvseries.data.repository.config.ConfigBackendRepository;
import com.internship.tvseries.data.repository.config.ConfigRetrofitRepository;

public final class Constants {
    public final static String BASE_URL = "https://api.themoviedb.org/3/";
    public final static String API_KEY = "3133b12095185ad24d14551d402e8a5c";
    public static final String CATEGORY_POPULAR = "popular";
    public static String IMAGE_BASE_URL;
    public final static String CATEGORY_TOP_RATED = "top_rated";

    public static void setImageBaseUrl() {
        ConfigBackendRepository.getInstance().getConfig(configuration -> {
            if (configuration == null) {
                ConfigRetrofitRepository.getInstance(ApiClient.getConfigApi()).getConfig(configuration1 ->
                        IMAGE_BASE_URL = configuration1.getImages().getSecureBaseUrl() + configuration1.getImages().getPosterSizes().get(5));
            } else
                IMAGE_BASE_URL = configuration.getImages().getSecureBaseUrl() + configuration.getImages().getPosterSizes().get(5);
        });
    }
}
