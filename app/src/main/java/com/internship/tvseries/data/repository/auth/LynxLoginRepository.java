package com.internship.tvseries.data.repository.auth;

import android.content.Context;
import android.content.SharedPreferences;

import com.internship.tvseries.data.api.LoginApi;
import com.internship.tvseries.data.model.AuthState;
import com.internship.tvseries.data.model.Credentials;
import com.internship.tvseries.data.model.LoginResponse;
import com.internship.tvseries.data.model.User;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LynxLoginRepository implements RemoteLoginRepository {

    private static LynxLoginRepository instance = null;
    private final LoginApi api;

    private LynxLoginRepository(LoginApi api) {
        this.api = api;
    }

    public static synchronized LynxLoginRepository getInstance(LoginApi api) {
        if (instance == null) {
            instance = new LynxLoginRepository(api);
        }
        return instance;
    }

    @Override
    public void login(String email, String password, Consumer<AuthState> consumer) {
        Credentials credentials = new Credentials(email, password);
        Call<LoginResponse> call = api.login(credentials);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NotNull Call<LoginResponse> call, @NotNull Response<LoginResponse> response) {
                if (response.code() == 200 && response.body() != null) {
                    consumer.accept(new AuthState(true));
                } else
                    consumer.accept(new AuthState("Login error"));
            }

            @Override
            public void onFailure(@NotNull Call<LoginResponse> call, @NotNull Throwable t) {
                consumer.accept(new AuthState(t.getMessage()));
            }
        });
    }

    @Override
    public boolean isLogged() {
        return false;
    }
}
