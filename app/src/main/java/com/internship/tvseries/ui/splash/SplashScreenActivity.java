package com.internship.tvseries.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.internship.tvseries.R;
import com.internship.tvseries.login_screen.login.LoginActivity;
import com.internship.tvseries.utils.Constants;


public class SplashScreenActivity extends AppCompatActivity {
    private boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Constants.setImageBaseUrl();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            if (!exit)
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }, 2000);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        exit = true;
    }
}