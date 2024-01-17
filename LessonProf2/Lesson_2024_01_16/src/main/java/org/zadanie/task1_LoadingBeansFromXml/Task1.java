package org.zadanie.task1_LoadingBeansFromXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zadanie.task1_LoadingBeansFromXml.entity.Customer;
import org.zadanie.task1_LoadingBeansFromXml.service.NotificationService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Customer customer1 = ctx.getBean(Customer.class);
        Customer customer2 = ctx.getBean(Customer.class);
        customer1.setId(1L);
        customer1.setName("Bob");
        customer1.setDateOfLastNotification(LocalDate.now());
        customer1.setPhone("+19138445656");
        customer2.setId(2L);
        customer2.setName("Sarah");
        customer2.setDateOfLastNotification(LocalDate.of(2024, 1, 16));
        customer2.setPhone("+19158455617");
        customer2.setEmail("sarah-sweet@candy.com");
        System.out.println();
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println();

        ApplicationContext ctx1 = new ClassPathXmlApplicationContext("beans2.xml");
        NotificationService notificationService = ctx1.getBean(NotificationService.class);
        customer1.setDateOfLastNotification(LocalDate.of(2023, 12, 17));
        customer2.setDateOfLastNotification(LocalDate.of(2023, 12, 17));
        List<Customer> customers = List.of(customer1, customer2);

        for (Customer customer : customers) {
            if (customer.getDateOfLastNotification() == null ||
                    ChronoUnit.DAYS.between(customer.getDateOfLastNotification(), LocalDate.now()) > 30) {
                if (customer.getEmail() != null) notificationService.getEmailNotificationService().sendSpam(customer);
                else notificationService.getSmsNotificationService().sendSpam(customer);
                customer.setDateOfLastNotification(LocalDate.now());
            }
        }
    }
}