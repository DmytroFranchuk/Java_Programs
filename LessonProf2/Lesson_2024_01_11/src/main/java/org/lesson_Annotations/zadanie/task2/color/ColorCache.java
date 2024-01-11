package org.lesson_Annotations.zadanie.task2.color;

import java.util.HashMap;
import java.util.Map;

public class ColorCache {

    private static final Map<String, Color> DEFAULT_COLORS = Map.of(
            "RED", new Color(255, 0, 0,255),
            "ORANGE", new Color(255, 106, 0,255),
            "YELLOW", new Color(255, 216, 0,255),
            "GREEN", new Color(0, 255, 0,255),
            "BLUE", new Color(0, 255, 255,255),
            "DARK_BLUE", new Color(0, 0, 255,255),
            "VIOLET", new Color(255, 0, 255,255),
            "BLACK", new Color(0, 0, 0,255),
            "WHITE", new Color(255, 255, 255,255)
    );
    private final Map<String, Color> cache;

    public ColorCache() {
        this.cache = new HashMap<>(DEFAULT_COLORS);
    }

    public Color plusRed(String prototypeName, int addRed, String nameColor) {
        Color prototype = cache.get(prototypeName);
        if (prototype == null) throw new IllegalArgumentException("Шаблон отсутствует");
        Color newColor = prototype.clone();
        newColor.setRed(newColor.getRed() + addRed);
        cache.put(nameColor, newColor);
        return newColor;
    }
    public Color minusRed(String prototypeName, int takeRed, String nameColor) {
        Color prototype = cache.get(prototypeName);
        if (prototype == null) throw new IllegalArgumentException("Шаблон отсутствует");
        Color newColor = prototype.clone();
        newColor.setRed(newColor.getRed() - takeRed);
        cache.put(nameColor, newColor);
        return newColor;
    }
    public Color plusGreen(String prototypeName, int addGreen, String nameColor) {
        Color prototype = cache.get(prototypeName);
        if (prototype == null) throw new IllegalArgumentException("Шаблон отсутствует");
        Color newColor = prototype.clone();
        newColor.setRed(newColor.getRed() + addGreen);
        cache.put(nameColor, newColor);
        return newColor;
    }
    public Color minusGreen(String prototypeName, int takeGreen, String nameColor) {
        Color prototype = cache.get(prototypeName);
        if (prototype == null) throw new IllegalArgumentException("Шаблон отсутствует");
        Color newColor = prototype.clone();
        newColor.setRed(newColor.getRed() - takeGreen);
        cache.put(nameColor, newColor);
        return newColor;
    }
    public Color plusBlue(String prototypeName, int addBlue, String nameColor) {
        Color prototype = cache.get(prototypeName);
        if (prototype == null) throw new IllegalArgumentException("Шаблон отсутствует");
        Color newColor = prototype.clone();
        newColor.setRed(newColor.getRed() + addBlue);
        cache.put(nameColor, newColor);
        return newColor;
    }
    public Color minusBlue(String prototypeName, int takeBlue, String nameColor) {
        Color prototype = cache.get(prototypeName);
        if (prototype == null) throw new IllegalArgumentException("Шаблон отсутствует");
        Color newColor = prototype.clone();
        newColor.setRed(newColor.getRed() - takeBlue);
        cache.put(nameColor, newColor);
        return newColor;
    }
    public Color plusAlpha(String prototypeName, int addAlpha, String nameColor) {
        Color prototype = cache.get(prototypeName);
        if (prototype == null) throw new IllegalArgumentException("Шаблон отсутствует");
        Color newColor = prototype.clone();
        newColor.setRed(newColor.getRed() + addAlpha);
        cache.put(nameColor, newColor);
        return newColor;
    }
    public Color minusAlpha(String prototypeName, int takeAlpha, String nameColor) {
        Color prototype = cache.get(prototypeName);
        if (prototype == null) throw new IllegalArgumentException("Шаблон отсутствует");
        Color newColor = prototype.clone();
        newColor.setRed(newColor.getRed() - takeAlpha);
        cache.put(nameColor, newColor);
        return newColor;
    }


}
