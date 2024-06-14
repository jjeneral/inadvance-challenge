package com.jjeneral.inadvancechallenge.controller;

import com.jjeneral.inadvancechallenge.fixture.UserFixture;
import com.jjeneral.inadvancechallenge.model.entity.User;
import com.jjeneral.inadvancechallenge.model.request.UserRequest;
import com.jjeneral.inadvancechallenge.model.response.UserResponse;
import com.jjeneral.inadvancechallenge.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Mock
    ConversionService conversionService;

    @Test
    void findAll() {


        when(userService.findAll()).thenReturn(UserFixture.getUserList());
        when(conversionService.convert(any(User.class), any(Class.class))).thenReturn(UserFixture.getUserResponse());

        List<UserResponse> actual = userController.findAll();
        List<UserResponse> expected = UserFixture.getUserResponseList();

        assertEquals(expected.size(), actual.size());
        assertEquals(expected.getFirst().getEmail(), actual.getFirst().getEmail());

    }

    @Test
    void findById() {
        when(userService.getUserById(UserFixture.UUID_USER_ID_TEST)).thenReturn(UserFixture.getUser());
        when(conversionService.convert(any(User.class), any(Class.class))).thenReturn(UserFixture.getUserResponse());

        UserResponse actual = userController.findById(UserFixture.UUID_USER_ID_TEST);
        UserResponse expected = UserFixture.getUserResponse();

        assertNotNull(actual);
        assertEquals(expected.getEmail(), actual.getEmail());

    }

    @Test
    void create() {
        when(conversionService.convert(any(UserRequest.class), eq(User.class))).thenReturn(UserFixture.getUser());
        when(conversionService.convert(any(User.class), eq(UserResponse.class))).thenReturn(UserFixture.getUserResponse());
        when(userService.createUser(any(User.class))).thenReturn(UserFixture.getUser());

        UserResponse actual = userController.create(UserFixture.getUserRequest());
        UserResponse expected = UserFixture.getUserResponse();

        assertNotNull(actual);
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getPhones().size(), actual.getPhones().size());
        assertEquals(expected.getPhones().getFirst(), actual.getPhones().getFirst());

    }

    @Test
    void update() {
        when(conversionService.convert(any(UserRequest.class), eq(User.class))).thenReturn(UserFixture.getUser());
        when(conversionService.convert(any(User.class), eq(UserResponse.class))).thenReturn(UserFixture.getUserResponse());
        when(userService.updateUser(any(User.class), eq(UserFixture.UUID_USER_ID_TEST))).thenReturn(UserFixture.getUser());

        UserResponse actual = userController.update(UserFixture.getUserRequest(), UserFixture.UUID_USER_ID_TEST);
        UserResponse expected = UserFixture.getUserResponse();

        assertNotNull(actual);
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getPhones().size(), actual.getPhones().size());
        assertEquals(expected.getPhones().getFirst(), actual.getPhones().getFirst());

    }
}