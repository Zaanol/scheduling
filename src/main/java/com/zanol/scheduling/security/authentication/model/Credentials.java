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
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}