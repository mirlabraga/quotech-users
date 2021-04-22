package com.quotech.quotechusers.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserId implements Serializable {

    private String clientId;

    private String userId;

    public UserId() {
    }

    public UserId(String clientId, String userId) {
        this.clientId = clientId;
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserId{" +
                "clientId='" + clientId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
