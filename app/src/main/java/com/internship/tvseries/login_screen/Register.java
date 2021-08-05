package com.internship.tvseries.login_screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.internship.tvseries.MainActivity;
import com.internship.tvseries.R;

public class Register extends AppCompatActivity {

    EditText registerName, registerEmail, registerPassword, registerConfPassword;
    Button registerBtn;
    FirebaseAuth fAuth;


    Button ScndLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerName = findViewById(R.id.RegisterName);
        registerEmail = findViewById(R.id.RegisterEmail);
        registerPassword = findViewById(R.id.RegisterPassword);
        registerConfPassword = findViewById(R.id.ConfRegisterPassword);
        registerBtn = findViewById(R.id.RegisterButton);

        fAuth = FirebaseAuth.getInstance();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = registerName.getText().toString();
                String Email = registerEmail.getText().toString();
                String Password = registerPassword.getText().toString();
                String ConfPassword = registerConfPassword.getText().toString();

                if(Name.isEmpty()){
                    registerName.setError("Name is required");
                    return;
                }

                if(Email.isEmpty()){
                    registerEmail.setError("Email address is required");
                    return;
                }

                if(Password.isEmpty()){
                    registerPassword.setError("Password is required");
                    return;
                }

                if(ConfPassword.isEmpty()){
                    registerConfPassword.setError("Please verify your password");
                    return;
                }

                if(!Password.equals(ConfPassword)){
                    registerConfPassword.setError("Passwords doesn't match");
                    return;
                }

                //data is validated
                //register the user with firebase

                Toast.makeText(Register.this, "Data Validated", Toast.LENGTH_SHORT).show();

                fAuth.createUserWithEmailAndPassword(Email, Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        //send user on next page
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        ScndLoginBtn = findViewById(R.id.ScndLoginBtn);
        ScndLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });
    }
}