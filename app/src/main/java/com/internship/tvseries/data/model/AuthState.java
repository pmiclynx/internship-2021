package com.internship.tvseries.data.model;

public class AuthState {
    private boolean isSuccessful;
    private String errorMessage;

    public AuthState() {
        isSuccessful = false;
        errorMessage = "";
    }

    public AuthState(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public AuthState(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
