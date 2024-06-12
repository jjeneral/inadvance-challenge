package com.jjeneral.inadvancechallenge.controller;

import com.jjeneral.inadvancechallenge.model.entity.User;
import com.jjeneral.inadvancechallenge.model.request.UserRequest;
import com.jjeneral.inadvancechallenge.model.response.UserResponse;
import com.jjeneral.inadvancechallenge.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ConversionService conversionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody UserRequest userRequest) {
        return conversionService.convert(
                userService.createUser(
                        conversionService.convert(userRequest, User.class)
                ), UserResponse.class);
    }

    @PutMapping("/{userId}")
    public UserResponse update(@Valid @RequestBody UserRequest userRequest, @PathVariable UUID userId) {
        return conversionService.convert(
                userService.updateUser(
                        conversionService.convert(userRequest, User.class), userId
                ), UserResponse.class);
    }

}
