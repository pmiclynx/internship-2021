package com.internship.tvseries.ui.favorites;
import androidx.fragment.app.Fragment;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Favorite Movies")
public class FavoritesFragment extends Fragment {

    //public static String BASE_URL = "https://api.themoviedb.org/3/";
    @PrimaryKey
    private int id;





}