package org.ls_21_11_2023_serialzajia.user;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Account account = new Account("mas", "123", "mas@com.ua");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Account.data"))) {
            out.writeObject(account);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Account account1 = loadAccount("Account.data");
        System.out.println(account1.getPassword());


    }

    public static Account loadAccount(String path) throws IOException {
        Account account = null;
        try(ObjectInputStream input = new ObjectInputStream(newInputStream(Path.of(path)))) {
            Object o = null;
            try {
                o = input.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (o instanceof Account) return (Account) o;
        }
        return account;
    }
}
