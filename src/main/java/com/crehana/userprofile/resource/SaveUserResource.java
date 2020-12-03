package com.crehana.userprofile.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveUserResource {

    @NotNull
    @Size(max = 50)
    private String userName;

    @NotNull
    @Size(max = 30)
    private String password;

    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String lastName;

    @NotNull
    @Size(max = 100)
    private String typeUser;

    public String getUserName() {
        return userName;
    }

    public SaveUserResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveUserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveUserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SaveUserResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public SaveUserResource setTypeUser(String typeUser) {
        this.typeUser = typeUser;
        return this;
    }
}
