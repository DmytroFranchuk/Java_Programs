package org.example.task1;

public class Pizza {
    private String crust;
    private String sauce;
    private boolean cheese;
    private boolean pepperoni;
    private boolean vegetables;

    private Pizza(String crust, String sauce, boolean cheese, boolean pepperoni, boolean vegetables) {
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.vegetables = vegetables;
    }

    public String getCrust() {
        return crust;
    }

    public String getSauce() {
        return sauce;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }

    public boolean hasVegetables() {
        return vegetables;
    }

    public static class PizzaBuilder {
        private String crust;
        private String sauce;
        private boolean cheese;
        private boolean pepperoni;
        private boolean vegetables;

        public PizzaBuilder crust(String crust) {
            this.crust = crust;
            return this;
        }

        public PizzaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder cheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder pepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public PizzaBuilder vegetables(boolean vegetables) {
            this.vegetables = vegetables;
            return this;
        }

        public Pizza build() {
            return new Pizza(crust, sauce, cheese, pepperoni, vegetables);
        }
    }
}
