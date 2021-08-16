package com.internship.tvseries;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.internship.tvseries.data.api.LynxApiClient;
import com.internship.tvseries.data.model.MoviesList;
import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO delete this later
//        Call<MoviesList> call = LynxApiClient.getMovieApi().listOfMovies(Constants.CATEGORY_POPULAR);
//        call.enqueue(new Callback<MoviesList>() {
//            @Override
//            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
//                if (response.code() == 200) {
//                    MoviesList movies = response.body();
//                    if (movies != null) {
//                        List<Result> list = movies.getResults();
//                        list.forEach(tv -> {
//                            Log.v("test", tv.getName());
//                        });
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MoviesList> call, Throwable t) {
//                Log.v("test", "fail" + t.getMessage());
//            }
//        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigatin_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}