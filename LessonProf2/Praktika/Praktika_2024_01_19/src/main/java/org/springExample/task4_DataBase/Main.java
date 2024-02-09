package org.springExample.task4_DataBase;

import org.springExample.task4_DataBase.config.DatabaseConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        DatabaseConfig databaseConfig = context.getBean("databaseConfig", DatabaseConfig.class);
        System.out.println(databaseConfig);
        context.close();
    }
}
// В ресурсах создайте файл настроек приложения application.properties.
// Укажите в файле настройки подключения к базе данных: url, логин и пароль.
// Для хранения настроек создайте класс DatabaseConfig и определите его бин.
// При определении бина укажите, что данные для бина должны быть получены из application.properties.
// Выведите бин DatabaseConfig в консоль.