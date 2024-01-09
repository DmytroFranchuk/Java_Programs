package org.example.task1;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Consumer consumer = new Consumer(car);
        Producer producer = new Producer(car);

        producer.start();
        consumer.start();
    }
}
//Есть отправитель и потребитель, в компании есть только одна машина для отправки груза, напишите программу,
// которая позволит получателю получать груз Для этого создайте классы Car, Cargo(груз), Consumer(будет содержать
// массив Cargo для отправки - последнее значение null - индикатор окончания отправки), Producer(получает карго),
// в машине может содержаться только один груз P.S. решение задачи очень похоже на классную работу