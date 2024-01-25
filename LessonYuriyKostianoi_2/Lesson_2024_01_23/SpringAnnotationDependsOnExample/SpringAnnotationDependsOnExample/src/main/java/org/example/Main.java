package org.example;

import org.example.config.MyAppConfig;
import org.example.file.processor.FileProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
        context.getBean(FileProcessor.class);
        context.close();
    }
}
