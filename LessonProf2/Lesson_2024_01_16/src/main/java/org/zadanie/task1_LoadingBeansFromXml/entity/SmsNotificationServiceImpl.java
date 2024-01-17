package org.zadanie.task1_LoadingBeansFromXml.entity;

import org.zadanie.task1_LoadingBeansFromXml.interfaces.SmsNotificationService;

public class SmsNotificationServiceImpl implements SmsNotificationService {
    @Override
    public void sendSpam(Customer customer) {
        System.out.println("Send sms spam: " + customer.getPhone()
                + " next shipment: " + customer.getDateOfLastNotification().plusDays(30));
    }
}
