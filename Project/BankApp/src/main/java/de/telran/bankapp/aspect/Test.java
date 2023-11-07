package de.telran.bankapp.aspect;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("Telran_123"));
        System.out.println(encoder.encode("Manager101_123"));
        System.out.println(encoder.encode("Client1_123"));

    }

}
