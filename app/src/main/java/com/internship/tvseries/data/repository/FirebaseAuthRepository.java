package com.internship.tvseries.data.repository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAuthRepository {

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

    public Task<AuthResult> register(String email, String password) {
        return firebaseAuth.createUserWithEmailAndPassword(email, password);
    }

}
