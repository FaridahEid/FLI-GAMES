package com.PC_Games_DB.errors;

public class publisherError {
    private boolean loginError;
    private boolean oldPasswordError;
    private boolean newPasswordError;

    public boolean isLoginError() {
        return loginError;
    }

    public void setLoginError(boolean loginError) {
        this.loginError = loginError;
    }

    public boolean isOldPasswordError() {
        return oldPasswordError;
    }

    public void setOldPasswordError(boolean oldPasswordError) {
        this.oldPasswordError = oldPasswordError;
    }

    public boolean isNewPasswordError() {
        return newPasswordError;
    }

    public void setNewPasswordError(boolean newPasswordError) {
        this.newPasswordError = newPasswordError;
    }
}
