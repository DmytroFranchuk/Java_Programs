import person.Person;

import java.lang.reflect.InvocationTargetException;

public class MainConstructor {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName(Person.class.getName());
            Person person = (Person) clazz.newInstance(); // работает только с конструктором по умолчанию
            System.out.println(person);

            // вызов конструктора с параметрами
            Class[] params = {String.class, int.class};
            person = (Person) clazz.getConstructor(params).newInstance("Frankenstein's Monster", 100);
            System.out.println(person);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}