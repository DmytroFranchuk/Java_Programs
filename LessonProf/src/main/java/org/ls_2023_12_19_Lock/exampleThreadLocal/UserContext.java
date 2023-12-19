package org.ls_2023_12_19_Lock.exampleThreadLocal;

import lombok.Getter;

public class UserContext {

    private static ThreadLocal<String> context = new ThreadLocal<>();

    public static String getContext() {
        return context.get();
    }

    public static void login(String username) {
        context.set(username);
        System.out.println(username + " logged in");
    }
    public static void logout() {
        String user = context.get();
        System.out.println(user + " logged out");
        context.remove();
    }
}
