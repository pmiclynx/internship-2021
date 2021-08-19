package com.internship.tvseries.utils;

import com.internship.tvseries.data.api.TheMovieDBApiClient;
import com.internship.tvseries.data.repository.config.LynxConfigRepository;
import com.internship.tvseries.data.repository.config.TheMovieDbConfigRepository;

public final class Constants {
    public final static String THEMOVIEDB_BASE_URL = "https://api.themoviedb.org/3/";
    public final static String LYNX_BASE_URL = "http://watched-it.web-staging.eu/api/";
    public final static String API_KEY = "3133b12095185ad24d14551d402e8a5c";
    public static final String CATEGORY_POPULAR = "popular";
    public static String IMAGE_BASE_URL;
    public final static String CATEGORY_TOP_RATED = "top_rated";

    public static void setImageBaseUrl() {
        TheMovieDbConfigRepository.getInstance(TheMovieDBApiClient.getConfigApi()).getConfig(configuration1 ->
                IMAGE_BASE_URL = configuration1.getImages().getSecureBaseUrl() + configuration1.getImages().getPosterSizes().get(5));
    }
}
