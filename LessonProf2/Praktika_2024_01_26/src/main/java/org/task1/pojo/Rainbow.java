package org.task1.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Rainbow {
    private List<Color> colorList;

    @Autowired
    public Rainbow(List<Color> colorList) {
        this.colorList = colorList;
    }

    @Override
    public String toString() {
        return "Rainbow{" +
                "colorList=" + colorList +
                '}';
    }
}
