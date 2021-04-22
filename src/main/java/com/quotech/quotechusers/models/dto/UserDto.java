package com.quotech.quotechusers.models.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quotech.quotechusers.models.User;
import com.quotech.quotechusers.models.UserId;

import java.io.Serializable;

public class UserDto implements Serializable {

    private UserDtoId userId;

    private Metadata metadata;

    public UserDto() {
    }

    public UserDto(UserDtoId userId, Metadata metadata) {
        this.userId = userId;
        this.metadata = metadata;
    }

    public UserDtoId getId() {
        return userId;
    }

    public void setId(UserDtoId userId) {
        this.userId = userId;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }


    public static User fromDto(UserDto dto) {
        User obj = new User(new UserId(dto.getId().getClientId(),
                dto.getId().getUserId()),
                dto.getMetadata().getName(),
                dto.getMetadata().getEmail(),
                dto.getMetadata().getRole());
        return obj;
    }

    public static UserDto toDto(User obj) {
        Metadata metadata = new Metadata(obj.getName(), obj.getEmail(), obj.getRole());
        UserDto dto = new UserDto(new UserDtoId(obj.getId().getClientId(), obj.getId().getUserId()), metadata);
        return dto;
    }

}
