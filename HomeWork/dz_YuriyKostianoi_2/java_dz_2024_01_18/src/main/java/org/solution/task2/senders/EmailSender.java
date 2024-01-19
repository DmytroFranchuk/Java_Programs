package org.solution.task2.senders;

import org.solution.task2.generator.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    private final MessageGenerator messageGenerator;

    @Autowired
    public EmailSender(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }

    public void sendEmail() {
        String message = messageGenerator.generateMessage();
        System.out.println("Sending email: " + message);
    }
}
