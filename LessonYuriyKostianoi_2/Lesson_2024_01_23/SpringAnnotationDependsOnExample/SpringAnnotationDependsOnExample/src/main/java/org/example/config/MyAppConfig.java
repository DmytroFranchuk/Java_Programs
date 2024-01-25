package org.example.config;

import org.example.file.processor.FileProcessor;
import org.example.file.reader.FileReader;
import org.example.file.writer.FileWriter;
import org.example.shared.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"org.example.file", "org.example.shared"})
public class MyAppConfig {
    @Autowired
    File file;

    @Bean("fileProcessor")
    @DependsOn({"fileReader", "fileWriter"})
    @Lazy
    public FileProcessor fileProcessor() {
        return new FileProcessor(file);
    }

    @Bean("fileReader")
    public FileReader fileReader() {
        return new FileReader(file);
    }

    @Bean("fileWriter")
    public FileWriter fileWriter() {
        return new FileWriter(file);
    }
}
