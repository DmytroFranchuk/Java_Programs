package org.task2.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan("org.task2.pojo")
public class Config {
    @Bean
    @Lazy
    public Connector connector() {
        return new Connector();
    }

    @Bean
    public DataCollectionService dataCollectionService() {
        return new DataCollectionService();
    }
}
