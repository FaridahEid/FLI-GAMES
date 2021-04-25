package com.PC_Games_DB.errors;

public class DevAdminError {

    private boolean isLoginError;
    private boolean isOldPasswordError;
    private boolean isNewPasswordError;
    private boolean isEmailError;

    public void setLoginError(boolean loginError) {
        isLoginError = loginError;
    }

    public boolean isLoginError() {
        return isLoginError;
    }

    public void setOldPasswordError(boolean oldPasswordError) {
        isOldPasswordError = oldPasswordError;
    }

    public boolean isOldPasswordError() {
        return isOldPasswordError;
    }

    public void setNewPasswordError(boolean newPasswordError) {
        isNewPasswordError = newPasswordError;
    }

    public boolean isNewPasswordError() {
        return isNewPasswordError;
    }

    public void setEmailError(boolean emailError) {
        isEmailError = emailError;
    }

    public boolean isEmailError() {
        return isEmailError;
    }
}
