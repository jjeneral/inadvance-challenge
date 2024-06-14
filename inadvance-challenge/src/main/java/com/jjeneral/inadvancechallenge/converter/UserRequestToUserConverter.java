package com.jjeneral.inadvancechallenge.converter;

import com.jjeneral.inadvancechallenge.model.entity.User;
import com.jjeneral.inadvancechallenge.model.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRequestToUserConverter implements Converter<UserRequest, User> {
    private final PhoneDtoToPhoneConverter phoneDtoToPhoneConverter;

    @Override
    public User convert(UserRequest source) {
        return User.builder()
                .name(source.getName())
                .email(source.getEmail())
                .password(source.getPassword())
                .isactive(source.getIsactive())
                .phones(source.getPhones().stream()
                        .map(phoneDtoToPhoneConverter::convert)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
