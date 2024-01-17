package org.zadanie.task1_LoadingBeansFromXml.service;

import org.zadanie.task1_LoadingBeansFromXml.interfaces.EmailNotificationService;
import org.zadanie.task1_LoadingBeansFromXml.interfaces.SmsNotificationService;

public class NotificationService {
    private SmsNotificationService smsNotificationService;
    private EmailNotificationService emailNotificationService;

    public NotificationService(SmsNotificationService smsNotificationService, EmailNotificationService emailNotificationService) {
        this.smsNotificationService = smsNotificationService;
        this.emailNotificationService = emailNotificationService;
    }

    public SmsNotificationService getSmsNotificationService() {
        return smsNotificationService;
    }

    public EmailNotificationService getEmailNotificationService() {
        return emailNotificationService;
    }

    @Override
    public String toString() {
        return "NotificationService{" +
                "smsNotificationService=" + smsNotificationService +
                ", emailNotificationService=" + emailNotificationService +
                '}';
    }
}
