package com.jjeneral.inadvancechallenge.model.request;

import com.jjeneral.inadvancechallenge.model.dto.PhoneDto;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private Set<PhoneDto> phones;
}