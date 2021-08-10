package com.internship.tvseries.login_screen.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.AuthState;
import com.internship.tvseries.data.repository.auth.AuthRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

public class RegisterViewModel extends BaseViewModel {

    private final AuthRepository authRepository;
    private final MutableLiveData<AuthState> _registerSuccess = new MutableLiveData<>();
    public LiveData<AuthState> registerSuccess = _registerSuccess;

    public RegisterViewModel(AuthRepository authRepository) {
        this.authRepository = authRepository;
        authRepository.addAuthenticationSuccessListener(_registerSuccess::postValue);
    }

    public void register(String email, String password) {
        authRepository.register(email, password);
    }
}
