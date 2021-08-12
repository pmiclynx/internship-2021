package com.internship.tvseries.data.repository.favorites;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.internship.tvseries.data.model.TvDetailsResponse;

import java.util.List;

@Dao
public interface FavoritesDao {

    @Insert
    long insertFavorite(TvDetailsResponse result);

    @Delete
    int deleteFavorite(TvDetailsResponse result);

    @Query("SELECT * FROM favorites")
    List<TvDetailsResponse> getAllFavorites();

    @Query("SELECT * FROM favorites where id = :id")
    TvDetailsResponse findById(int id);
}
