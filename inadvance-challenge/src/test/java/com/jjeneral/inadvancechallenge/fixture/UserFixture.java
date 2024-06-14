package com.jjeneral.inadvancechallenge.fixture;

import com.jjeneral.inadvancechallenge.model.entity.User;
import com.jjeneral.inadvancechallenge.model.request.UserRequest;
import com.jjeneral.inadvancechallenge.model.response.UserResponse;

import java.util.List;
import java.util.UUID;

public class UserFixture {
    public static final UUID UUID_USER_ID_TEST = UUID.fromString("952aa7c4-29df-4e12-b288-4d77d219c494");

    public static List<UserResponse> getUserResponseList() {
        return List.of(getUserResponse());
    }

    public static UserResponse getUserResponse() {
        return UserResponse.builder()
                .userId(UUID_USER_ID_TEST)
                .name("Juan Rodriguez")
                .email("juan@rodriguez.org")
                .password("hunter2")
                .phones(List.of(PhoneFixture.getPhoneDto()))
                .build();

    }

    public static List<User> getUserList() {
        return List.of(getUser());
    }

    public static User getUser() {
        return User.builder()
                .userId(UUID_USER_ID_TEST)
                .name("Juan Rodriguez")
                .email("juan@rodriguez.org")
                .password("hunter2")
                .phones(List.of(PhoneFixture.getPhone()))
                .build();
    }

    public static UserRequest getUserRequest() {
        UserResponse userResponse = getUserResponse();
        return UserRequest.builder()
                .name(userResponse.getName())
                .email(userResponse.getEmail())
                .password(userResponse.getPassword())
                .phones(userResponse.getPhones())
                .build();
    }


}
