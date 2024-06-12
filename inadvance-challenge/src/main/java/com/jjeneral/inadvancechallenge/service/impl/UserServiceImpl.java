package com.jjeneral.inadvancechallenge.service.impl;

import com.jjeneral.inadvancechallenge.model.entity.User;
import com.jjeneral.inadvancechallenge.repository.UserRepository;
import com.jjeneral.inadvancechallenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
