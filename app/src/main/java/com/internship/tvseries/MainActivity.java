package com.internship.tvseries;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //The theme should be changed back to the app theme before the setContentView call
        setTheme(R.style.Theme_TvSeries);

        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigatin_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}