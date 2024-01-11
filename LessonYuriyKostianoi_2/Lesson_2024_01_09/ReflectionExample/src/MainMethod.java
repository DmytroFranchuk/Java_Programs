import java.lang.reflect.Method;

public class MainMethod {

    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("person.Person");
            Method[] methlist = cls.getDeclaredMethods();
            for (Method m : methlist) {
                System.out.println("name = " + m.getName());
                System.out.println("decl class = " + m.getDeclaringClass()); // показывает, из какого класса метод
                Class[] pvec = m.getParameterTypes();
                for (int j = 0; j < pvec.length; j++)
                    System.out.println(" param #" + j + "" + pvec[j]);
                Class[] evec = m.getExceptionTypes();
                for (int j = 0; j < evec.length; j++)
                    System.out.println("exc #" + j + " " + evec[j]);
                System.out.println("return type = " + m.getReturnType());
                System.out.println("---------------------");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}