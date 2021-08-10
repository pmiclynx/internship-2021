package com.internship.tvseries.data.repository.auth;

//Interface for the authentication repository
public interface AuthRepository {
    void register(String email, String password);
    void addAuthenticationSuccessListener(AuthenticationSuccessListener listener);
}
