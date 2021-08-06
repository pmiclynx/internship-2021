package com.internship.tvseries.data.repository;

import com.internship.tvseries.data.model.TvDetailsResponse;

import java.util.List;

public class FavoritesRepository {

    private final FavoritesDao favoritesDao;

    private static FavoritesRepository instance = null;

    private FavoritesRepository(FavoritesDao favoritesDao) {
        this.favoritesDao = favoritesDao;
    }

    public static FavoritesRepository getInstance(FavoritesDao favoritesDao) {
        if (instance == null)
            instance = new FavoritesRepository(favoritesDao);

        return instance;
    }

    public long insert(TvDetailsResponse result) {
        return favoritesDao.insertFavorite(result);
    }

    public int delete(TvDetailsResponse result) {
        return favoritesDao.deleteFavorite(result);
    }

    public List<TvDetailsResponse> getAll() {
        return favoritesDao.getAllFavorites();
    }
}
