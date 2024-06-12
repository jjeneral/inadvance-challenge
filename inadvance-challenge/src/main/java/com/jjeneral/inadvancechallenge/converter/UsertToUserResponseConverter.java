package com.jjeneral.inadvancechallenge.converter;

import com.jjeneral.inadvancechallenge.model.entity.User;
import com.jjeneral.inadvancechallenge.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsertToUserResponseConverter implements Converter<User, UserResponse> {
    private final PhoneToPhoneDtoConverter phoneToPhoneDtoConverter;
    @Override
    public UserResponse convert(User source) {
        return UserResponse.builder()
                .name(source.getName())
                .email(source.getEmail())
                .password(source.getPassword())
                .phones(source.getPhones().stream()
                        .map(phoneToPhoneDtoConverter::convert)
                        .collect(Collectors.toSet())
                )
                .created(source.getCreated())
                .build();
    }
}
