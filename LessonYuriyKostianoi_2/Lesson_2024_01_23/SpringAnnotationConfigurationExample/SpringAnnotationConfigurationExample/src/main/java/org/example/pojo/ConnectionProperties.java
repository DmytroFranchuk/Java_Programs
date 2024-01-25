package org.example.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public record ConnectionProperties(
        @Value("${connect.host}") String host,
        @Value("${connect.port}") int port,
        @Value("${connect.token}")String token
) { }
