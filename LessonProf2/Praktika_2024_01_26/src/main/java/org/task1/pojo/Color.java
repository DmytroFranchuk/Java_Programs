package org.task1.pojo;

public class Color {
    private String name;

    public Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                '}';
    }
}
