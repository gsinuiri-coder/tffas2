package com.crehana.userprofile.resource;


import com.crehana.userprofile.domain.model.AuditModel;

public class UserResource extends AuditModel {

    private Long id;
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String typeUser;


    public Long getId() {
        return id;
    }

    public UserResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public UserResource setTypeUser(String typeUser) {
        this.typeUser = typeUser;
        return this;
    }
}
