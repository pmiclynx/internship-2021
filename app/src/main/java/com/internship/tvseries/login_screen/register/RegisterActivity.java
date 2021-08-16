package com.internship.tvseries.login_screen.register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.common.api.Api;
import com.internship.tvseries.MainActivity;
import com.internship.tvseries.data.api.LynxApiClient;
import com.internship.tvseries.databinding.ActivityRegisterBinding;
import com.internship.tvseries.login_screen.login.LoginActivity;
import com.internship.tvseries.ui.base.BaseActivity;
import com.internship.tvseries.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

public class RegisterActivity extends BaseActivity<RegisterViewModel> {

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

        viewModel.registerSuccess.observe(this, authState -> {
            if (authState.isSuccessful()) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            } else
                Toast.makeText(RegisterActivity.this, authState.getErrorMessage(), Toast.LENGTH_SHORT).show();
        });

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
            //register the user
            viewModel.register(Name, Email, Password, ConfPassword);
        });

        binding.ScndLoginBtn.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });
    }


}