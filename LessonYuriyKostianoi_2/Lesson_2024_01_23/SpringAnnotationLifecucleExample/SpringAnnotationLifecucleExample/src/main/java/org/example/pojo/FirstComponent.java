package org.example.pojo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class FirstComponent {
    private static final String PREFIX = FirstComponent.class.getSimpleName() + ": ";

    public FirstComponent() {
        System.out.println(PREFIX + "Создание бина");
    }

    @PostConstruct
    public void start() {
        System.out.println(PREFIX + "После создания бина");
    }
    @PreDestroy
    public void finish() {
        System.out.println(PREFIX + "Перед удалением бина");
    }

    @Override
    public String toString() {
        return "I'm the FirstComponent made using @Component";
    }
}
