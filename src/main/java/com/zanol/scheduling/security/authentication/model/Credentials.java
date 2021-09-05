package com.zanol.scheduling.security.authentication.model;

public class Credentials {

    private String userCode;
    private String userPassword;

    public Credentials() {
    }

    public Credentials(String userCode, String userPassword) {
        this.userCode = userCode;
        this.userPassword = userPassword;
    }

    public String getUserCode() {
        if (this.userCode == null)
            this.userCode = "";

        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        if (this.userPassword == null)
            this.userPassword = "";

        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean isFilled() {
        this.userCode = this.userCode.trim();
        this.userPassword = this.userPassword.trim();

        return this.userCode != null
                && !this.userCode.isBlank()
                && this.userPassword != null
                && !this.userPassword.isBlank();
    }
}