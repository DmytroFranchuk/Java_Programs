package org._lessonExamples.SpringXmlBeanLifecycleExample;

import org._lessonExamples.SpringXmlBeanLifecycleExample.logger.SingletonLogger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("beans/SpringXmlBeanLifecycleExample.xml");
        SingletonLogger logger = context.getBean("singletonLogger", SingletonLogger.class);
        logger.debug("Hello world!");
        logger.info("Be cool");
        logger.warning("I warning you");
        logger.error("It's error. Oh, no!");
        context.close();
    }
}
