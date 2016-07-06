package com.todolist.model.user;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by cemkaya on 03/07/16.
 */
public class UserForm {

    @NotEmpty
    private String username = "";
    @NotEmpty
    private String password = "";
    @NotEmpty
    private String passwordRepeated = "";
    private String error = "";

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordRepeated() {
        return passwordRepeated;
    }
    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }
    public String getError() {return error;}
    public void setError(String error) {this.error = error;}


}
