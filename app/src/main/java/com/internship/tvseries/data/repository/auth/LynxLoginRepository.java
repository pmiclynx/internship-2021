package com.internship.tvseries.data.repository.auth;

import com.internship.tvseries.data.model.AuthState;
import com.internship.tvseries.data.repository.RemoteLoginRepository;

import java.util.function.Consumer;

public class LynxLoginRepository implements RemoteLoginRepository {

    public LynxLoginRepository(){}

    @Override
    public void login(String email, String password, Consumer<AuthState> consumer) {
        consumer.accept(null);
    }

    @Override
    public boolean isLogged() {
        return false;
    }
}
