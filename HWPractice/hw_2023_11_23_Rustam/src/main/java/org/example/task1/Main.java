package org.example.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beansConfig.xml");

        PaymentGateway paymentGateway = ctx.getBean(PaymentGateway.class);
        paymentGateway.processPayment();
    }
}