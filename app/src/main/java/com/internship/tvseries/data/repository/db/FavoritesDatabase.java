package com.internship.tvseries.data.repository.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.favorites.FavoritesDao;

@Database(entities = {TvDetailsResponse.class}, version = 1)
public abstract class FavoritesDatabase extends RoomDatabase {

   public abstract FavoritesDao favoritesDao();

   private static FavoritesDatabase instance = null;

   public static FavoritesDatabase getInstance(Context context) {
       if (instance == null)
           instance = Room.databaseBuilder(context, FavoritesDatabase.class, "favorites_database").build();

       return instance;
   }

}
