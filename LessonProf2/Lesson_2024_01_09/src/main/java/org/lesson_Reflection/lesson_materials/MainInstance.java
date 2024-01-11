package org.lesson_Reflection.lesson_materials;

public class MainInstance {
    private static class A { }
    private static class B extends A { }

    public static void main(String[] args) {
        try {
            Class<?> cls = A.class;
            boolean b1 = cls.isInstance(Integer.valueOf(37)); // false
            System.out.println(b1);
            boolean b2 = cls.isInstance(new A()); // true
            System.out.println(b2);
            boolean b3 = cls.isInstance(new B()); // true
            System.out.println(b3);
            A ab = new B();
            B bb = B.class.cast(ab); // эквивалентно (B)ab
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}