package com.internship.tvseries.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.internship.tvseries.R;
import com.internship.tvseries.login_screen.Login;
import com.internship.tvseries.utils.Constants;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Constants.setImageBaseUrl();

        boolean h = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        }, 2000);
    }
}