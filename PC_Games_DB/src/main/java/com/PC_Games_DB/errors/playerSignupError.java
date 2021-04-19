package com.PC_Games_DB.errors;

public class playerSignupError {
    private boolean gamerIDError;
    private boolean passwordError;
    private boolean emailError;
    private boolean DOBError;
    private boolean gamerIDTaken;

    public boolean isGamerIDError() {
        return gamerIDError;
    }

    public void setGamerIDError(boolean gamerIDError) {
        this.gamerIDError = gamerIDError;
    }

    public boolean isPasswordError() {
        return passwordError;
    }

    public void setPasswordError(boolean passwordError) {
        this.passwordError = passwordError;
    }

    public boolean isEmailError() {
        return emailError;
    }

    public void setEmailError(boolean emailError) {
        this.emailError = emailError;
    }

    public boolean isDOBError() {
        return DOBError;
    }

    public void setDOBError(boolean DOBError) {
        this.DOBError = DOBError;
    }

    public boolean isGamerIDTaken() {
        return gamerIDTaken;
    }

    public void setGamerIDTaken(boolean gamerIDTaken) {
        this.gamerIDTaken = gamerIDTaken;
    }
}
