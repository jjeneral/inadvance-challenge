package com.jjeneral.inadvancechallenge.service.impl;

import com.jjeneral.inadvancechallenge.model.entity.User;
import com.jjeneral.inadvancechallenge.repository.UserRepository;
import com.jjeneral.inadvancechallenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(UUID userId) {
        return userRepository.getReferenceById(userId);
    }

    @Transactional
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, UUID userId) {
        User userToUpdate = userRepository.getReferenceById(userId);
        BeanUtils.copyProperties(user, userToUpdate, "userId");

        return userRepository.save(user);
    }
}
