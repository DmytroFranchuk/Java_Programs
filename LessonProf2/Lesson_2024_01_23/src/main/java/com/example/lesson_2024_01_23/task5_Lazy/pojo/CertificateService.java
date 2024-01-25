package com.example.lesson_2024_01_23.task5_Lazy.pojo;

public class CertificateService {
    public CertificateService() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Получение сертификата: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
