package com.internship.tvseries.data.repository.auth;

import com.internship.tvseries.data.model.AuthState;

import java.util.function.Consumer;

public class LynxRegisterRepository implements RemoteRegisterRepository {

    private static LynxRegisterRepository instance;

    private LynxRegisterRepository() {}

    public static LynxRegisterRepository getInstance() {
        synchronized (LynxRegisterRepository.class) {
            if (instance == null)
                instance = new LynxRegisterRepository();
        }
        return instance;
    }

    @Override
    public void register(String email, String password, Consumer<AuthState> consumer) {
        //TODO implement method
        consumer.accept(null);
    }
}
