package com.internship.tvseries.data.repository.auth;

import com.internship.tvseries.data.model.AuthState;

public interface AuthenticationSuccessListener {
    void onReceived(AuthState authState);
}
