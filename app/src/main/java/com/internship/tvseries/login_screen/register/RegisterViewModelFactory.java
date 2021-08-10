package com.internship.tvseries.login_screen.register;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.internship.tvseries.data.repository.FirebaseAuthRepository;

import org.jetbrains.annotations.NotNull;

public class RegisterViewModelFactory implements ViewModelProvider.Factory {

    private FirebaseAuthRepository authRepository;

    public RegisterViewModelFactory(FirebaseAuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @NonNull
    @NotNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RegisterViewModel.class))
            return (T) new RegisterViewModel(authRepository);
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}
