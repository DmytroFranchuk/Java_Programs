package org.ls_2023_12_19_Lock.exampleThreadLocal;

public class Main {
    public static void main(String[] args) {
        UserContext.login("Dima Toropushka");
        Thread t = new Thread(() -> {
            UserContext.login("Fedor Kopipastov");
            System.out.println(UserContext.getContext());
            UserContext.logout();
        });
        UserContext.logout();
        t.start();
    }
}
