package com.jjeneral.inadvancechallenge.converter;

import com.jjeneral.inadvancechallenge.model.dto.PhoneDto;
import com.jjeneral.inadvancechallenge.model.entity.Phone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PhoneToPhoneDtoConverter implements Converter<Phone, PhoneDto> {
    @Override
    public PhoneDto convert(Phone source) {
        return PhoneDto.builder()
                .number(source.getNumber())
                .citycode(source.getCitycode())
                .countrycode(source.getCountrycode())
                .build();
    }
}
