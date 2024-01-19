package org.springExample.task1_World;

public class World {
    private String name;


    public World(String name) {
        this.name = name;
        System.out.println("Сотворение мира X");
    }

    public void printСivilization() {
        System.out.println("Восход цивилизаций");
    }

    public void printFinalWorld() {
        System.out.println("Конец Света");
    }

    @Override
    public String toString() {
        return "World{" +
                "name='" + name + '\'' +
                '}';
    }
}
