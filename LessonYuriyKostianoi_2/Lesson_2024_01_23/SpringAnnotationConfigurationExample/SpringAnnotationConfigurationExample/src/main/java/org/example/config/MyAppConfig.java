package org.example.config;

import org.example.pojo.FirstBean;
import org.example.pojo.SecondBean;
import org.springframework.context.annotation.*;

import java.util.Random;

@Configuration
@ComponentScan("org.example.pojo")
@PropertySource("classpath:application.properties")
public class MyAppConfig {
    @Bean // имя бина совпадает с названием метода
    @Scope("prototype")
    public Random random() {
        return new Random();
    }

    @Bean(name = "first", autowireCandidate = false, initMethod = "start", destroyMethod = "finish")
    public FirstBean firstBean() {
        return new FirstBean();
    }

    @Bean(name = "second")
    public SecondBean secondBean() {
        return new SecondBean(firstBean());
    }
}
