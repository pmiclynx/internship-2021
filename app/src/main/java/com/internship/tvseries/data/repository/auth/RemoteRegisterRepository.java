package com.internship.tvseries.data.repository.auth;

import com.internship.tvseries.data.model.AuthState;

import java.util.function.Consumer;

//Interface for the authentication repository
public interface RemoteRegisterRepository {

    void register(String name, String email, String password, String password_confirmation, Consumer<AuthState> consumer);
}
