package com.internship.tvseries.login_screen.register;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.internship.tvseries.data.repository.auth.RemoteRegisterRepository;

import org.jetbrains.annotations.NotNull;

public class RegisterViewModelFactory implements ViewModelProvider.Factory {

    private final RemoteRegisterRepository remoteRegisterRepository;
    private final RemoteRegisterRepository lynxRegisterRepository;

    public RegisterViewModelFactory(RemoteRegisterRepository remoteRegisterRepository, RemoteRegisterRepository lynxRegisterRepository) {
        this.remoteRegisterRepository = remoteRegisterRepository;
        this.lynxRegisterRepository = lynxRegisterRepository;
    }

    @NonNull
    @NotNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RegisterViewModel.class))
            return (T) new RegisterViewModel(remoteRegisterRepository, lynxRegisterRepository);
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}
