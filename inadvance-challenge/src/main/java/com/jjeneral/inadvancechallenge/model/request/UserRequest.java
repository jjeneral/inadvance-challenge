package com.jjeneral.inadvancechallenge.model.request;

import com.jjeneral.inadvancechallenge.constraint.CorreoDisponible;
import com.jjeneral.inadvancechallenge.constraint.CreateGroup;
import com.jjeneral.inadvancechallenge.constraint.FormatoPassword;
import com.jjeneral.inadvancechallenge.model.dto.PhoneDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserRequest {
    @NotBlank(message = "Debe ingresar name")
    private String name;
    @NotBlank(message = "Debe ingresar email")
    @Email(message = "Email no válido")
    @CorreoDisponible(groups = CreateGroup.class)
    private String email;
    @NotBlank(message = "Debe ingresar password")
    @FormatoPassword
    private String password;
    private Boolean isactive;
    private List<PhoneDto> phones;
}