package org.ls_2023_11_21_serialzajia.propertiesSystem;

import java.net.URI;
import java.util.Map;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Map<String, String> vars = System.getenv();
        vars.forEach((k, v) -> System.out.println(k + " : " + v));
//        if (!vars.containsKey("ABC")) System.out.println("Нет параметра");
//        else System.out.println("Существует " + vars.keySet().contains("ABC"));

        Properties prop = System.getProperties();
        prop.forEach((k, v) -> System.out.println(k + " : " + v));
        prop.get("os.name");
        System.out.printf("%s Ты лучший препоподаватель", URI.create(vars.get("JavaBro")));
    }
}
