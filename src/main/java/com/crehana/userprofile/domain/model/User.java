package com.crehana.userprofile.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_subscriptions",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "subscription_id")})
    @JsonIgnore
    private List<Subscription> subscriptions;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isTaggedWith(Subscription subscription) {
        return (this.getSubscriptions().contains(subscription));
    }

    public User tagWith(Subscription subscription) {
        if(!this.isTaggedWith(subscription)) {
            this.getSubscriptions().add(subscription);
        }
        return this;
    }

    public User unTagWith(Subscription subscription) {
        if(this.isTaggedWith(subscription)) {
            this.getSubscriptions().remove(subscription);
        }
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public User setTypeUser(String typeUser) {
        this.typeUser = typeUser;
        return this;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public User setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
        return this;
    }
}
