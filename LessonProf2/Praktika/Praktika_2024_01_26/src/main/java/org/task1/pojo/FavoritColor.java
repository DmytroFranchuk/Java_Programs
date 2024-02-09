package org.task1.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FavoritColor {
    private Color color;

    @Autowired
    public FavoritColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "FavoritColor{" +
                "color=" + color +
                '}';
    }
}
