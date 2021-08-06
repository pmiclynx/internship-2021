package com.internship.tvseries.data.repository;

import com.internship.tvseries.data.model.Result;

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

    public long insert(Result result) {
        return favoritesDao.insertFavorite(result);
    }

    public int delete(Result result) {
        return favoritesDao.deleteFavorite(result);
    }

    public List<Result> getAll() {
        return favoritesDao.getAllFavorites();
    }
}
