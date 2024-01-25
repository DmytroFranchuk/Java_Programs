package org.example.config;

import org.example.components.FirstBean;
import org.example.components.SecondBean;
import org.example.components.LazyBean;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example.components")
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
