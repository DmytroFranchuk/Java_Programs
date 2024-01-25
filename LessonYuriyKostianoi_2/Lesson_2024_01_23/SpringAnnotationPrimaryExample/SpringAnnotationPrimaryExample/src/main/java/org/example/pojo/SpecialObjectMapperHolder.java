package org.example.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SpecialObjectMapperHolder {
    private final ObjectMapper mapper;

    @Autowired
    public SpecialObjectMapperHolder(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public String toJson(LocalDateTime dateTime) {
        try {
            return mapper.writeValueAsString(dateTime);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
