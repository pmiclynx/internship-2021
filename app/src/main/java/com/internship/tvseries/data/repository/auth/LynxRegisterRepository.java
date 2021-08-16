package com.internship.tvseries.data.repository.auth;

import androidx.lifecycle.MutableLiveData;

import com.internship.tvseries.data.api.RegisterApi;
import com.internship.tvseries.data.model.AuthState;
import com.internship.tvseries.data.model.RegisterRequest;
import com.internship.tvseries.data.model.RegisterResponse;
import com.internship.tvseries.databinding.ActivityRegisterBinding;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LynxRegisterRepository implements RemoteRegisterRepository {

    private static LynxRegisterRepository instance;
    private RegisterApi registerApi;
    private LynxRegisterRepository(RegisterApi registerApi) {
        this.registerApi= registerApi;
    }

    public static LynxRegisterRepository getInstance(RegisterApi registerApi) {
        synchronized (LynxRegisterRepository.class) {
            if (instance == null)
                instance = new LynxRegisterRepository(registerApi);
        }
        return instance;
    }


    @Override
    public void register(String name, String email, String password, String password_confirmation, Consumer<AuthState> consumer) {
        Call<RegisterResponse> responseCall= registerApi.registerUser(new RegisterRequest(name, email, password, password_confirmation));
       responseCall.enqueue(new Callback<RegisterResponse>() {
           @Override
           public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
               consumer.accept(new AuthState(true));
           }
           @Override
           public void onFailure(Call<RegisterResponse> call, Throwable t) {
                consumer.accept(new AuthState(t.getMessage()));
           }
       });



        consumer.accept(null);
    }
}
