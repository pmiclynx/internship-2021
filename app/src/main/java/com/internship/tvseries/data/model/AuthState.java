package com.internship.tvseries.data.model;

//This class
public class AuthState {
    private boolean isSuccessful;
    private String errorMessage;

    public AuthState() {
        isSuccessful = false;
        errorMessage = "";
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
