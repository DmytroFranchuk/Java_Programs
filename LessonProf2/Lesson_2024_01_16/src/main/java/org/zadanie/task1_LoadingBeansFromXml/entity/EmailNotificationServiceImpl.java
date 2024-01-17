package org.zadanie.task1_LoadingBeansFromXml.entity;

import org.zadanie.task1_LoadingBeansFromXml.interfaces.EmailNotificationService;

public class EmailNotificationServiceImpl implements EmailNotificationService {
    @Override
    public void sendSpam(Customer customer) {
        System.out.println("Send email spam: " + customer.getEmail()
                + " next shipment: " + customer.getDateOfLastNotification().plusDays(30));
    }
}
