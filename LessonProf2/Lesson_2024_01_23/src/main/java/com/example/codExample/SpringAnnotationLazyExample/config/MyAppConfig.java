package com.example.codExample.SpringAnnotationLazyExample.config;

import com.example.codExample.SpringAnnotationLazyExample.components.FirstBean;
import com.example.codExample.SpringAnnotationLazyExample.components.LazyBean;
import com.example.codExample.SpringAnnotationLazyExample.components.SecondBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan("com.example.codExample.SpringAnnotationLazyExample.components")
//@Lazy
public class MyAppConfig {
    @Lazy
    @Bean
    public LazyBean lazyBean() {
        return new LazyBean();
    }

    @Bean
    public FirstBean firstBean() {
        return new FirstBean();
    }

    @Bean
    public SecondBean secondBean() {
        return new SecondBean();
    }
}
