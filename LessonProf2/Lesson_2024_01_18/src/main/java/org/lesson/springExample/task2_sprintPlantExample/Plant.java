package org.lesson.springExample.task2_sprintPlantExample;

public class Plant {

    private Plant() {
    }

    public static Plant produceNewPlant() {
        System.out.println("Выращиваем новое растение Запущен метод produceNewPlant");
        return new Plant();
    }
}
