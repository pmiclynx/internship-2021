package com.internship.tvseries.login_screen.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.internship.tvseries.data.repository.LoginRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

public class LoginViewModel extends BaseViewModel {
    private LoginRepository repository;
    private MutableLiveData<FirebaseUser> userData;

    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public LoginViewModel(@NonNull LoginRepository repository){
        this.repository=repository;
        userData=repository.getFirebaseUserMutableLiveData();
    }

    public Task<AuthResult> login(String username, String password){
        return repository.login(username,password);
    }
    public boolean loggedin(){
        return repository.loggedin();
    }
}
