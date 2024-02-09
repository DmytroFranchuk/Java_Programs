package org.task1.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class ColorProvider {
    private Map<String, Color> nameToColor;

    @Autowired
    public ColorProvider(Map<String, Color> nameToColor) {
        this.nameToColor = nameToColor;
    }

    @Override
    public String toString() {
        return "ColorProvider{" +
                "nameToColor=" + nameToColor +
                '}';
    }
}
