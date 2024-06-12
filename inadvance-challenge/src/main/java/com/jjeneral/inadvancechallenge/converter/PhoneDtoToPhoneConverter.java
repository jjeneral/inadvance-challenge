package com.jjeneral.inadvancechallenge.converter;

import com.jjeneral.inadvancechallenge.model.dto.PhoneDto;
import com.jjeneral.inadvancechallenge.model.entity.Phone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PhoneDtoToPhoneConverter implements Converter<PhoneDto, Phone> {
    @Override
    public Phone convert(PhoneDto source) {
        return Phone.builder()
                .number(source.getNumber())
                .citycode(source.getCitycode())
                .countrycode(source.getCountrycode())
                .build();
    }
}
