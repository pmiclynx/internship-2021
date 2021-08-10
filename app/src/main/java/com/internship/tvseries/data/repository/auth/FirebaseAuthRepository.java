package com.internship.tvseries.data.repository.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.internship.tvseries.data.model.AuthState;

//Authentication repository using Firebase
public class FirebaseAuthRepository implements AuthRepository {

    private static FirebaseAuthRepository instance = null;
    private final FirebaseAuth firebaseAuth;
    private AuthenticationSuccessListener listener;

    private FirebaseAuthRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public static FirebaseAuthRepository getInstance() {
        if (instance == null)
            instance = new FirebaseAuthRepository();
        return instance;
    }

    @Override
    public void register(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> listener.onReceived(new AuthState(true)))
                .addOnFailureListener(e -> listener.onReceived(new AuthState(e.getMessage())));
    }

    @Override
    public void addAuthenticationSuccessListener(AuthenticationSuccessListener listener) {
        this.listener = listener;
    }
}
