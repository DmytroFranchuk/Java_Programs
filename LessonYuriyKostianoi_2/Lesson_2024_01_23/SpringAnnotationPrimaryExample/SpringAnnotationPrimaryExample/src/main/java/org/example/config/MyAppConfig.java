package org.example.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

@Configuration
@ComponentScan("org.example.pojo")
public class MyAppConfig {
    @Bean("objectMapper")
    public ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        return new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(module);
    }

    @Bean("objectMapperWithDateTimeModule")
    @Primary // аннотация делвет бин приоритетным для автоматического внедрения
    public ObjectMapper objectMapperWithDateTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
        ObjectMapper mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(module);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        mapper.setDateFormat(df);
        return mapper;
    }
}
