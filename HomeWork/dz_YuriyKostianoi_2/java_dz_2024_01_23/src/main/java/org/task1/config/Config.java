package org.task1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.task1.entities.Task;
import org.task1.entities.impl.EmailNotificationService;
import org.task1.entities.impl.PushNotificationService;
import org.task1.entities.impl.SmsNotificationService;
import org.task1.entities.service.NotificationService;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan({"org.task1"})
@PropertySource("classpath:application.properties")
public class Config {

//    @Value("${taskList.default.size}")
//    private int taskListSize;
//
//    @Bean
//    public List<Task> taskList() {
//        return new ArrayList<>(taskListSize) ;
//    }

//    @Bean("email")
//    public NotificationService emailNotificationService() {
//        return new EmailNotificationService();
//    }
//
//    @Bean("sms")
//    public NotificationService smsNotificationService() {
//        return new SmsNotificationService();
//    }
//
//    @Bean("push")
//    public NotificationService pushNotificationService() {
//        return new PushNotificationService();
//    }
}
