package com.jjeneral.inadvancechallenge.service;

import com.jjeneral.inadvancechallenge.model.entity.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID userId);
    User createUser(User user);
    User updateUser(User user, UUID userId);
}
