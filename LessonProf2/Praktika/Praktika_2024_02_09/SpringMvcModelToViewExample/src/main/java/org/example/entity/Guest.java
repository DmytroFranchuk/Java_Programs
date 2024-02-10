package org.example.entity;

public record Guest(long id, String name, int order) {
}

// Задание
// Создайте приложение для кафе, которое запоминает имя посетителя и время его первого заказа.
// Посетитель может делать заказы и получать скидку на каждый новый заказ в течение текущих
// суток (для упрощения приложения в течение 180 секунд).
// После 17:00 система «забывает» про посетителей и обнуляет их скидочный купон.
// Используйте Session scope бин для хранения информации о посетителе и времени его первого заказа.
// Создайте контроллер для обработки заказов и выдачи скидок для посетителя в этот день.