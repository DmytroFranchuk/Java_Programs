package org.example.message;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class MessageGenerator {
    private final Queue<String> messages = new LinkedList<>(List.of(
            "Welcome",
            "Please complete your registration",
            "Thank you for the registration",
            "Please log in", "Logged in",
            "Logged out"
    ));

    public Optional<String> nextMessage() {
        return Optional.ofNullable(messages.poll());
    }

    public int remainingMessages() {
        return messages.size();
    }
}
