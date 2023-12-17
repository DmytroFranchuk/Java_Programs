package org.pr_2023_12_15;

public class New {
    public static void main(String[] args) {
        LeafPileSimulation simulation = new LeafPileSimulation();

        // Дети собирают листья в кучу
        simulation.collectLeaves();

        // Дети начинают прыгать в кучу
        simulation.jumpIntoPile();

        // Снова собирают кучу, так как куча стала слишком маленькой
        simulation.collectLeaves();

    }
}
