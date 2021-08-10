package com.internship.tvseries.data.repository;

import androidx.lifecycle.LiveData;

import com.internship.tvseries.data.model.AuthState;

//Interface for the authentication repository
public interface AuthRepository {
    void register(String email, String password);
    LiveData<AuthState> getRegisterIsSuccessful();
}
