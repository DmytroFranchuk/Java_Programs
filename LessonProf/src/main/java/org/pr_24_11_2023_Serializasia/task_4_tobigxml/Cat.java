package org.pr_24_11_2023_Serializasia.task_4_tobigxml;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@XmlType(name = "cat")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cat {
    private int age;
    private String color;
    private double weight;
    private Owner owner;
    @XmlElementWrapper(name = "food_list")
    private List<Food> foods;

    public Cat() {
    }

    public Cat(int age, String color, double weight, Owner owner, List<Food> foods) {
        this.age = age;
        this.color = color;
        this.weight = weight;
        this.owner = owner;
        this.foods = foods;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Double.compare(weight, cat.weight) == 0 && Objects.equals(color, cat.color) && Objects.equals(owner, cat.owner) && Objects.equals(foods, cat.foods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, color, weight, owner, foods);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Кот: возраст - ");
        builder.append(age)
                .append(", цвет - ")
                .append(color)
                .append(", вес - ")
                .append(weight)
                .append(".\n")
                .append("    ")
                .append(owner)
                .append("\n")
                .append("    Предпочитаемая еда:\n");
        for (Food currentFood : foods) {
            builder.append("        ").append(currentFood).append("\n");
        }
        return builder.toString();
    }
}
