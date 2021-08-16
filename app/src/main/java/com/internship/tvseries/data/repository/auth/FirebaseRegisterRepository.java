package com.internship.tvseries.data.repository.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.internship.tvseries.data.model.AuthState;

import java.util.function.Consumer;

//Authentication repository using Firebase
public class FirebaseRegisterRepository implements RemoteRegisterRepository {

    private static FirebaseRegisterRepository instance = null;
    private final FirebaseAuth firebaseAuth;

    private FirebaseRegisterRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public static FirebaseRegisterRepository getInstance() {
        synchronized (FirebaseRegisterRepository.class) {
            if (instance == null)
                instance = new FirebaseRegisterRepository();
        }
        return instance;
    }

    @Override
    public void register(String email, String password, Consumer<AuthState> consumer) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> consumer.accept(new AuthState(true)))
                .addOnFailureListener(e -> consumer.accept(new AuthState(e.getMessage())));
    }

}
