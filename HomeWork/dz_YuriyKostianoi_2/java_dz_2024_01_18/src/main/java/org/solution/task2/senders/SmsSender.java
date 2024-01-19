package org.solution.task2.senders;

import org.solution.task2.generator.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmsSender {
    private final MessageGenerator messageGenerator;

    @Autowired
    public SmsSender(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }

    public void sendSms() {
        String message = messageGenerator.generateMessage();
        System.out.println("Sending SMS: " + message);
    }
}
