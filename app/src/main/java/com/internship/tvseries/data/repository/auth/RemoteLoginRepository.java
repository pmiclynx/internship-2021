package com.internship.tvseries.data.repository.auth;

import com.internship.tvseries.data.model.AuthState;

import java.util.function.Consumer;

public interface RemoteLoginRepository {
    void login(String email, String password, Consumer<AuthState> consumer);

    boolean isLogged();
}
