package com.internship.tvseries.login_screen.register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.internship.tvseries.MainActivity;
import com.internship.tvseries.databinding.ActivityRegisterBinding;
import com.internship.tvseries.login_screen.Login;
import com.internship.tvseries.ui.base.BaseActivity;
import com.internship.tvseries.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

public class Register extends BaseActivity<RegisterViewModel> {

    private ActivityRegisterBinding binding;

    @NonNull
    @NotNull
    @Override
    public RegisterViewModel createViewModel() {
        RegisterViewModelFactory factory = InjectorUtils.getInstance().provideRegisterViewModelFactory();
        return new ViewModelProvider(this, factory).get(RegisterViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.RegisterButton.setOnClickListener(v -> {
            String Name = binding.RegisterName.getText().toString();
            String Email = binding.RegisterEmail.getText().toString();
            String Password = binding.RegisterPassword.getText().toString();
            String ConfPassword = binding.ConfRegisterPassword.getText().toString();

            if (Name.isEmpty()) {
                binding.RegisterName.setError("Name is required");
                return;
            }
            if (Email.isEmpty()) {
                binding.RegisterEmail.setError("Email address is required");
                return;
            }
            if (Password.isEmpty()) {
                binding.RegisterPassword.setError("Password is required");
                return;
            }
            if (ConfPassword.isEmpty()) {
                binding.ConfRegisterPassword.setError("Please verify your password");
                return;
            }
            if (!Password.equals(ConfPassword)) {
                binding.ConfRegisterPassword.setError("Passwords doesn't match");
                return;
            }

            //data is validated
//            Toast.makeText(Register.this, "Data Validated", Toast.LENGTH_SHORT).show();
            //register the user
            viewModel.register(Email, Password);
            viewModel.registerSuccess.observe(this, authState -> {
                if (authState.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } else
                    Toast.makeText(Register.this, authState.getErrorMessage(), Toast.LENGTH_SHORT).show();
            });
        });

        binding.ScndLoginBtn.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        });
    }


}