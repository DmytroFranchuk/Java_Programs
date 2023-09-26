package de.telran.bankapp.entity;

import de.telran.bankapp.entity.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status attribute) {
        return attribute.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String dbData) {
        return Status.valueOf(dbData);
    }
}
