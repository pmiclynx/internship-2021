package com.internship.tvseries.login_screen.login.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.AuthState;
import com.internship.tvseries.data.repository.RemoteLoginRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

import java.util.function.Consumer;

public class LoginViewModel extends BaseViewModel {
    private final RemoteLoginRepository repository;

    private final MutableLiveData<Boolean> _successLogin = new MutableLiveData<>();
    public final LiveData<Boolean> successLogin = _successLogin;

    private final MutableLiveData<String> _errorLogin = new MutableLiveData<>();
    public final LiveData<String> errorLogin = _errorLogin;


    public LoginViewModel(@NonNull RemoteLoginRepository repository) {
        this.repository = repository;
    }

    public void login(String email, String password) {
        repository.login(email, password, new Consumer<AuthState>() {
            @Override
            public void accept(AuthState authState) {
                if (authState.isSuccessful()) {
                    _successLogin.postValue(true);
                } else {
                    _errorLogin.postValue(authState.getErrorMessage());
                }
            }
        });
    }

    public void checkIfUserIsLogged() {
        if (repository.isLogged()) {
            _successLogin.postValue(true);
        }
    }
}
