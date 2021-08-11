package com.internship.tvseries.data.repository.auth;

import com.internship.tvseries.data.model.AuthState;

import java.util.function.Consumer;

//Interface for the authentication repository
public interface AuthRepository {
    void register(String email, String password, Consumer<AuthState> consumer);
}
