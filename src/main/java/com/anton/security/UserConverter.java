package com.anton.security;

import com.anton.model.User;
import com.anton.model.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private final PasswordEncoder encoder;

    public UserConverter(final PasswordEncoder encoder){
        this.encoder=encoder;
    }

    public UserDto toDto(final User entity){
        return new UserDto(entity.getId(), "123", entity.getRole());
    }

    public User toEntity(final UserDto dto){
        return new User(dto.getId(), encoder.encode(dto.getPassword()), dto.getRole());
    }

    public User enrich(final User entity, final UserDto dto){
        entity.setPassword(encoder.encode(dto.getPassword()));
        entity.setRole(dto.getRole());
        return entity;
    }
}
