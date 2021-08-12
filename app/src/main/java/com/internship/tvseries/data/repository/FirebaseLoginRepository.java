package com.internship.tvseries.data.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.internship.tvseries.data.model.AuthState;

import java.util.function.Consumer;

public class FirebaseLoginRepository implements RemoteLoginRepository {
    private FirebaseAuth auth;

    public FirebaseLoginRepository() {
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(String email, String password, Consumer<AuthState> consumer) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(
                        authResult -> consumer.accept(new AuthState(true)))
                .addOnFailureListener(e -> consumer.accept(new AuthState(e.getMessage())));
    }

    @Override
    public boolean isLogged() {
        if (auth.getCurrentUser() != null) {
            return true;
        } else {
            return false;
        }
    }
}
