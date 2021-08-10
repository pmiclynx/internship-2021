package com.internship.tvseries.login_screen.register;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.internship.tvseries.data.repository.FirebaseAuthRepository;
import com.internship.tvseries.ui.base.BaseViewModel;

public class RegisterViewModel extends BaseViewModel {

    private final FirebaseAuthRepository authRepository;

    public RegisterViewModel(FirebaseAuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public Task<AuthResult> register(String email, String password) {
        return authRepository.register(email, password);
    }
}
