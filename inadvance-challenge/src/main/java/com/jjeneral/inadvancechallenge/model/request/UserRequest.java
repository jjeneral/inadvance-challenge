package com.jjeneral.inadvancechallenge.model.request;

import com.jjeneral.inadvancechallenge.model.dto.PhoneDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {
    @NotBlank(message = "Debe ingresar name")
    private String name;
    @NotBlank(message = "Debe ingresar email")
    private String email;
    @NotBlank(message = "Debe ingresar password")
    private String password;
    private Set<PhoneDto> phones;
}