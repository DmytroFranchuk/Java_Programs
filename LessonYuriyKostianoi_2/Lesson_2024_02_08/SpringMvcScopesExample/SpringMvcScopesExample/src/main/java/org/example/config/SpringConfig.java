package org.example.config;

import org.example.message.MessageGenerator;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;

@Configuration
public class SpringConfig {
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    @RequestScope
    public MessageGenerator requestMessageGenerator() {
        return new MessageGenerator();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    @SessionScope
    public MessageGenerator sessionMessageGenerator() {
        return new MessageGenerator();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    @ApplicationScope
    public MessageGenerator appMessageGenerator() {
        return new MessageGenerator();
    }

    @Bean
    @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MessageGenerator websocketMessageGenerator() {
        return new MessageGenerator();
    }
}
