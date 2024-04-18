package io.github.lumine1909.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class FieldAccessor {
    private Field field = null;

    public FieldAccessor(Class<?> clazz, int index, Class<?> type) {
        for (Field f : clazz.getDeclaredFields()) {
            if (f.getType().equals(type)) {
                if (index > 0) {
                    index--;
                    continue;
                }
                field = f;
                f.setAccessible(true);
                return;
            }
        }
    }

    public FieldAccessor(Class<?> clazz, String name) {
        try {
            field = clazz.getDeclaredField(name);
            field.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Field getField() {
        if (field == null) {
            throw new RuntimeException();
        }
        return field;
    }

    public Object get(Object o) {
        try {
            return field.get(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void set(Object o, Object value) {
        try {
            field.set(o, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}