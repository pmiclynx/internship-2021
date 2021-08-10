package com.internship.tvseries.login_screen;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.internship.tvseries.MainActivity;
import com.internship.tvseries.R;
import com.internship.tvseries.data.repository.LoginRepository;
import com.internship.tvseries.login_screen.viewmodel.LoginViewModel;
import com.internship.tvseries.ui.base.BaseActivity;

public class Login extends BaseActivity<LoginViewModel> {

    Button ScndRegisterButton, LoginButton;
    EditText username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(viewModel.loggedin()){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);


        ScndRegisterButton = findViewById(R.id.ScndRegisterButton);
        ScndRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        username = findViewById(R.id.LoginEmail);
        password = findViewById(R.id.LoginPassword);
        LoginButton = findViewById(R.id.LoginButton);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //extract/validate

                if(username.getText().toString().isEmpty()){
                    username.setError("Please enter the email");
                    return;
                }

                if(password.getText().toString().isEmpty()){
                    password.setError("Please enter the password");
                    return;
                }
                viewModel.login(username.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @NonNull
    @Override
    public LoginViewModel createViewModel() {
        LoginViewModelFactory factory= new LoginViewModelFactory(new LoginRepository());
        return new ViewModelProvider(this, factory).get(LoginViewModel.class);
    }
}