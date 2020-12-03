package com.crehana.userprofile.resource;

import com.crehana.userprofile.domain.model.AuditModel;

public class SubscriptionResource extends AuditModel {

    private Long id;
    private String status;
    private String type;

    public Long getId() {
        return id;
    }

    public SubscriptionResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SubscriptionResource setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getType() {
        return type;
    }

    public SubscriptionResource setType(String type) {
        this.type = type;
        return this;
    }
}
