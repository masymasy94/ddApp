package com.masy.ddapp.data.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

@Converter
public class BooleanMagicItemsConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return BooleanUtils.isTrue(value)? "required": "";
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        return StringUtils.equals(value, "required") ? true: null;
    }

}