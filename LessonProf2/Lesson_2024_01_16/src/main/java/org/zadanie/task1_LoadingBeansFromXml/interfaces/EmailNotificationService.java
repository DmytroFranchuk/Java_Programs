package org.zadanie.task1_LoadingBeansFromXml.interfaces;

import org.zadanie.task1_LoadingBeansFromXml.entity.Customer;

public interface EmailNotificationService {
    void sendSpam(Customer customer);
}
