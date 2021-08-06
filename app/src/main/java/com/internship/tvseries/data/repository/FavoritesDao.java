package com.internship.tvseries.data.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;

import com.internship.tvseries.data.model.Result;

import java.util.List;

@Dao
public interface FavoritesDao {

    @Insert
    long insertFavorite(Result result);

    @Delete
    int deleteFavorite(Result result);

    @Query("SELECT * FROM favorites")
    List<Result> getAllFavorites();
}
