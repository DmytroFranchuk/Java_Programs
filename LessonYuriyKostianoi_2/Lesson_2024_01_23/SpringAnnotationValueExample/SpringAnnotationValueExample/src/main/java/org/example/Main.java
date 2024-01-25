package org.example;

import org.example.pojo.DatabaseConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * В ресурсах создайте файл настроек приложения application.properties. Укажите в файле настройки подключения к базе
 * данных: url, логин и пароль. Для хранения настроек создайте класс DatabaseConfig и определите его бин.
 * При определении бина укажите, что данные для бина должны быть получены из application.properties.
 * Выведите бин DatabaseConfig в консоль.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DatabaseConfig creds = context.getBean("databaseConfig", DatabaseConfig.class);
        System.out.println(creds);
        context.close();
    }
}
