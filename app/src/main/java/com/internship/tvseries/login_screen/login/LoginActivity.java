package com.internship.tvseries.login_screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.internship.tvseries.MainActivity;
import com.internship.tvseries.R;
import com.internship.tvseries.login_screen.login.viewmodel.LoginViewModel;
import com.internship.tvseries.login_screen.register.RegisterActivity;
import com.internship.tvseries.ui.base.BaseActivity;
import com.internship.tvseries.utils.InjectorUtils;

public class LoginActivity extends BaseActivity<LoginViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button registerButton = findViewById(R.id.ScndRegisterButton);
        Button loginButton = findViewById(R.id.LoginButton);
        EditText etEmail = findViewById(R.id.LoginEmail);
        EditText etPassword = findViewById(R.id.LoginPassword);

        viewModel.successLogin.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean successLogin) {
                if (successLogin) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });

        viewModel.errorLogin.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {
                Log.e(LoginActivity.class.toString(), errorMessage);
                Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.checkIfUserIsLogged();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //extract/validate
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (email.isEmpty()) {
                    etEmail.setError("Please enter the email");
                    return;
                }

                if (password.isEmpty()) {
                    etPassword.setError("PLease enter the password");
                    return;
                }

                //is valid
                viewModel.login(email, password);
            }
        });
    }

    @NonNull
    @Override
    public LoginViewModel createViewModel() {
        LoginViewModelFactory factory = InjectorUtils.getInstance().provideLoginViewModelFactory(getApplicationContext());
        return new ViewModelProvider(this, factory).get(LoginViewModel.class);
    }
}