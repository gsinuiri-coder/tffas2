package com.crehana.userprofile.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "subscriptions")
public class Subscription extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String status;

    @NotNull
    private String type;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "subscriptions")
    @JsonIgnore
    private List<User> users;

    public Long getId() {
        return id;
    }

    public Subscription setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Subscription setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getType() {
        return type;
    }

    public Subscription setType(String type) {
        this.type = type;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public Subscription setUsers(List<User> users) {
        this.users = users;
        return this;
    }
}
