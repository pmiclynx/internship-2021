package com.internship.tvseries.login_screen.register;

import androidx.lifecycle.LiveData;

import com.internship.tvseries.data.model.AuthState;
import com.internship.tvseries.data.repository.AuthRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

public class RegisterViewModel extends BaseViewModel {

    private final AuthRepository authRepository;
    public LiveData<AuthState> registerSuccess;

    public RegisterViewModel(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void register(String email, String password) {
        authRepository.register(email, password);
        registerSuccess = authRepository.getRegisterIsSuccessful();
    }
}
