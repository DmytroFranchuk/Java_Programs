package org.ls_2023_11_21_serialzajia.user;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

    private String login;
    private String password;
    private String email;

    private static final long serialVersionUID = 2764L;

    public Account(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(login, account.login) && Objects.equals(password, account.password) && Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, email);
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
