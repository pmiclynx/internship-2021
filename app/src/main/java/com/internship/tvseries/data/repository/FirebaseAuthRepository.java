package com.internship.tvseries.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.internship.tvseries.data.model.AuthState;

//Authentication repository using Firebase
public class FirebaseAuthRepository implements AuthRepository {

    private static FirebaseAuthRepository instance = null;
    private final FirebaseAuth firebaseAuth;
    private final MutableLiveData<AuthState> registerIsSuccessful = new MutableLiveData<>();

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
        AuthState authState = new AuthState();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> authState.setSuccessful(true))
                .addOnFailureListener(e -> authState.setErrorMessage(e.getMessage()));
    }

    @Override
    public LiveData<AuthState> getRegisterIsSuccessful() {
        return registerIsSuccessful;
    }
}
