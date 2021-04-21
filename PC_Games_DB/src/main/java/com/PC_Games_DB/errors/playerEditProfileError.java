package com.PC_Games_DB.errors;

public class PlayerEditProfileError {
    private boolean oldPasswordError;
    private boolean newPasswordError;

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
