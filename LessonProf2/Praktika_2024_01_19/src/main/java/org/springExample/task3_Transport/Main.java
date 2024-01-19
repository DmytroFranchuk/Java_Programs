package org.springExample.task3_Transport;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext3.xml");

        Transport car = context.getBean("car", Transport.class);
        Transport bicycle = context.getBean("bicycle", Transport.class);
        Transport motorcycle = context.getBean("motorcycle", Transport.class);

        car.drive();
        bicycle.drive();
        motorcycle.drive();

        context.close();

    }
}
// Реализуйте простую систему создания различных видов транспортных средств.
// Создайте бин фабрики (TransportFactory), которая будет иметь метод createTransport,
// возвращающий различные виды транспортных средств (например, "Car", "Bicycle", "Motorcycle").
// Используйте factory-method для создания объектов.
// В описании бинов каждого из видов транспорта укажите
// factory-bean="transportFactory"
// factory-method="createTransport"