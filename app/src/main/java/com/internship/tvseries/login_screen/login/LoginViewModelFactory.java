package com.internship.tvseries.login_screen.login;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.internship.tvseries.data.repository.auth.RemoteLoginRepository;
import com.internship.tvseries.login_screen.login.viewmodel.LoginViewModel;

public class LoginViewModelFactory implements ViewModelProvider.Factory {

private final RemoteLoginRepository remoteLoginRepository;
private final RemoteLoginRepository lynxLoginRepository;
 public LoginViewModelFactory( RemoteLoginRepository remoteLoginRepository, RemoteLoginRepository lynxLoginRepository) {
        this.remoteLoginRepository = remoteLoginRepository;
        this.lynxLoginRepository=lynxLoginRepository;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> viewModelClass) {
            if (viewModelClass.isAssignableFrom(LoginViewModel.class)) {
                //noinspection unchecked
                return (T) new LoginViewModel(remoteLoginRepository,lynxLoginRepository);

            }
            throw new IllegalStateException("Unable to create " + viewModelClass.getName());
        }
}

