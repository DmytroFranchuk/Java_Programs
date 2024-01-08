package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

// Создайте проект Spring с помощью start.spring.io
// Создайте POJO класс.
// Настройте bean-компонент Student в файле bean-factory-demo.xml.

// Создайте проект Spring с помощью start.spring.io
// Создайте POJO класс.
// Настройте bean-компонент Student с помощью аннотации @Bean.

@SpringBootApplication
@ImportResource("classpath:bean-factory-demo.xml")
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		String[] beanNames = Arrays.stream(context.getBeanDefinitionNames())
				.sorted()
				.toArray(String[]::new);
		System.out.println("Список всех бинов в приложении:");
		int i = 1;
		for (String beanName : beanNames) {
			System.out.printf("%3s - %s%n", i++, beanName);
			if (beanName.equals("studentBean")) {
				printStudentInfo((Student) context.getBean(beanName));
			}
		}

		ApplicationContext context1 = new ClassPathXmlApplicationContext("bean-factory-demo.xml");
		Student student = (Student) context.getBean("studentBean");
		printStudentInfo(student);
	}

	public static void printStudentInfo(Student student) {
		System.out.println("===============================================");
		System.out.println("Student ID: " + student.getId());
		System.out.println("Student Age: " + student.getAge());
		System.out.println("Student Email: " + student.getEmail());
		System.out.println("Student Name: " + student.getName());
		System.out.println("===============================================");
	}
}
