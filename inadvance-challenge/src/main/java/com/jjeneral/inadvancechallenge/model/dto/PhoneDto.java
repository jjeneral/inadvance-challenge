package com.jjeneral.inadvancechallenge.model.dto;

import com.jjeneral.inadvancechallenge.model.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto implements Serializable {
    Integer number;
    Byte citycode;
    Short countrycode;
    UserResponse user;
}