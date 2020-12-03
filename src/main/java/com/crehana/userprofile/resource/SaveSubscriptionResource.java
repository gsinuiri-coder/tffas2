package com.crehana.userprofile.resource;


import javax.validation.constraints.NotNull;

public class SaveSubscriptionResource {

    @NotNull
    private String status;

    @NotNull
    private String type;

    public String getStatus() {
        return status;
    }

    public SaveSubscriptionResource setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getType() {
        return type;
    }

    public SaveSubscriptionResource setType(String type) {
        this.type = type;
        return this;
    }
}
