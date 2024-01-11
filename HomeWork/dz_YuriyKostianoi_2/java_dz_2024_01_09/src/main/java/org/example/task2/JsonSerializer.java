package org.example.task2;

import java.lang.reflect.Field;

public class JsonSerializer {
    public String serialize(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }
            if (value != null) {
                if (json.length() > 1) {
                    json.append(", ");
                }
                json.append("\"").append(fieldName).append("\":");
                if (field.getType().isPrimitive() || field.getType().equals(String.class)) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(serialize(value));
                }
            }
        }
        json.append("}");
        return json.toString();
    }

}
