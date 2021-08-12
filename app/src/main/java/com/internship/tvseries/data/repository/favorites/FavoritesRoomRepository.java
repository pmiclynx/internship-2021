package com.internship.tvseries.data.repository.favorites;

import com.internship.tvseries.data.model.TvDetailsResponse;

import java.util.List;
import java.util.function.Consumer;

public class FavoritesRoomRepository implements FavoritesRepository {

    private final FavoritesDao favoritesDao;

    private static FavoritesRoomRepository instance = null;

    private FavoritesRoomRepository(FavoritesDao favoritesDao) {
        this.favoritesDao = favoritesDao;
    }

    public static FavoritesRoomRepository getInstance(FavoritesDao favoritesDao) {
        if (instance == null)
            instance = new FavoritesRoomRepository(favoritesDao);

        return instance;
    }

    @Override
    public void insert(TvDetailsResponse result) {
        new Thread(() -> favoritesDao.insertFavorite(result));
    }

    @Override
    public void delete(TvDetailsResponse result) {
        new Thread(() -> favoritesDao.deleteFavorite(result));

    }

    @Override
    public void getAll(Consumer<List<TvDetailsResponse>> consumer) {
        consumer.accept(favoritesDao.getAllFavorites());
    }

    @Override
    public void findById(int id, Consumer<TvDetailsResponse> consumer) {
        consumer.accept(favoritesDao.findById(id));
    }
//
//    public List<TvDetailsResponse> getAll() {
//        return favoritesDao.getAllFavorites();
//    }
//
//    public TvDetailsResponse findById(int id) {
//        return favoritesDao.findById(id);
//    }
}
