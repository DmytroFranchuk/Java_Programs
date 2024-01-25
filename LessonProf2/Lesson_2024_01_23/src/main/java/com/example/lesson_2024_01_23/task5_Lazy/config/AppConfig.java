package com.example.lesson_2024_01_23.task5_Lazy.config;

import com.example.lesson_2024_01_23.task5_Lazy.pojo.CertificateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

    @Bean
    @Lazy
    public CertificateService certificateService() {
        return new CertificateService();

    }
//    @Bean
//    public BeanEntityExample beanEntityExample() {
//        return new BeanEntityExample();
//    }
}
