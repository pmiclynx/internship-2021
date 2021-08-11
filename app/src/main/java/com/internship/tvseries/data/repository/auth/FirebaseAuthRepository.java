package com.internship.tvseries.data.repository.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.internship.tvseries.data.model.AuthState;

import java.util.function.Consumer;

//Authentication repository using Firebase
public class FirebaseAuthRepository implements AuthRepository {

    private static FirebaseAuthRepository instance = null;
    private final FirebaseAuth firebaseAuth;

    private FirebaseAuthRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public static FirebaseAuthRepository getInstance() {
        if (instance == null)
            instance = new FirebaseAuthRepository();
        return instance;
    }

    @Override
    public void register(String email, String password, Consumer<AuthState> consumer) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> consumer.accept(new AuthState(true)))
                .addOnFailureListener(e -> consumer.accept(new AuthState(e.getMessage())));
    }

}
