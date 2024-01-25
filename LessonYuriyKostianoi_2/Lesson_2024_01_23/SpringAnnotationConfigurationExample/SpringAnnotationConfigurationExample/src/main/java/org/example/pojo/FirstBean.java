package org.example.pojo;

public class FirstBean {
    private static final String PREFIX = FirstBean.class.getSimpleName() + ": ";

    public FirstBean() {
        System.out.println(PREFIX + "Создание бина");
    }

    public void start() {
        System.out.println(PREFIX + "После создания бина");
    }

    public void finish() {
        System.out.println(PREFIX + "Перед удалением бина");
    }

    @Override
    public String toString() {
        return "I'm the FirstBean made using @Bean and @Configuration";
    }
}
