package org.solution.task2.scheduler;

import org.solution.task2.senders.EmailSender;
import org.solution.task2.senders.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class MessageSenderScheduler {
    private final SmsSender smsSender;
    private final EmailSender emailSender;

    @Autowired
    public MessageSenderScheduler(SmsSender smsSender, EmailSender emailSender) {
        this.smsSender = smsSender;
        this.emailSender = emailSender;
    }

    public void startSendingMessages(int number) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < number; i++) {
            int delay = i * 2;
            executorService.schedule(() -> { smsSender.sendSms(); emailSender.sendEmail(); },
                    delay, TimeUnit.SECONDS);
        }
        executorService.shutdown();
    }
}
