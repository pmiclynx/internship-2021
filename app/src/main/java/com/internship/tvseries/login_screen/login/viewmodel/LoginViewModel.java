package com.internship.tvseries.login_screen.login.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.AuthState;
import com.internship.tvseries.data.repository.auth.RemoteLoginRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

import java.util.function.Consumer;

public class LoginViewModel extends BaseViewModel {
    private final RemoteLoginRepository remoteLoginRepository;
    private final RemoteLoginRepository lynxLoginRepository;

    private final MutableLiveData<Boolean> _successLogin = new MutableLiveData<>();
    public final LiveData<Boolean> successLogin = _successLogin;

    private final MutableLiveData<String> _errorLogin = new MutableLiveData<>();
    public final LiveData<String> errorLogin = _errorLogin;


    public LoginViewModel(@NonNull RemoteLoginRepository remoteLoginRepository, RemoteLoginRepository lynxLoginRepository) {
        this.remoteLoginRepository = remoteLoginRepository;
        this.lynxLoginRepository = lynxLoginRepository;
    }

    public void login(String email, String password) {
        lynxLoginRepository.login(email, password, authState -> {
            if (authState == null) {
                remoteLoginRepository.login(email, password, new Consumer<AuthState>() {
                    @Override
                    public void accept(AuthState authState) {
                        if (authState.isSuccessful()) {
                            _successLogin.postValue(true);
                        } else {
                            _errorLogin.postValue(authState.getErrorMessage());
                        }
                    }
                });
            } else {
                if (authState.isSuccessful())
                    _successLogin.postValue(true);
                else
                    _errorLogin.postValue(authState.getErrorMessage());
            }
        });
    }

    public void checkIfUserIsLogged() {
        if (lynxLoginRepository.isLogged()) {
            _successLogin.postValue(true);
        } else if (remoteLoginRepository.isLogged()) {
            _successLogin.postValue(true);
        } else _successLogin.postValue(false);
    }
}
