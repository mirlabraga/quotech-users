package com.quotech.quotechusers.models.dto;

import java.io.Serializable;

public class UserDtoId implements Serializable {

    private String clientId;

    private String userId;

    public UserDtoId() {
    }

    public UserDtoId(String clientId, String userId) {
        this.userId = userId;
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "UserDtoId{" +
                "clientId='" + clientId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
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
}