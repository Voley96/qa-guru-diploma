package io.realworld.data;

public enum ErrorMessage {
    INVALID_CREDENTIALS("email or password is invalid"),
    BLANK_PASSWORD("password can't be blank"),
    BLANK_EMAIL("email can't be blank");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
