package com.internship.tvseries.login_screen.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.model.AuthState;
import com.internship.tvseries.data.repository.auth.RemoteRegisterRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

public class RegisterViewModel extends BaseViewModel {

    private final RemoteRegisterRepository remoteRegisterRepository;
    private final RemoteRegisterRepository lynxRegisterRepository;
    private final MutableLiveData<AuthState> _registerSuccess = new MutableLiveData<>();
    public LiveData<AuthState> registerSuccess = _registerSuccess;

    public RegisterViewModel(RemoteRegisterRepository remoteRegisterRepository, RemoteRegisterRepository lynxRegisterRepository) {
        this.remoteRegisterRepository = remoteRegisterRepository;
        this.lynxRegisterRepository = lynxRegisterRepository;
    }

    public void register(String name, String email, String password, String password_confirmation) {
        lynxRegisterRepository.register(name,email, password, password_confirmation, authState -> {
            if (authState == null) {
                remoteRegisterRepository.register(name, email, password, password_confirmation, _registerSuccess::postValue);
            } else {
                _registerSuccess.postValue(authState);
            }
        });
    }
}
