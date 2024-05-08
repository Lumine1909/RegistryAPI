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
                field.setAccessible(true);
                return;
            }
        }
    }

    public FieldAccessor(Class<?> clazz, String name) {
        try {
            field = clazz.getDeclaredField(name);
            field.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
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
            field.setAccessible(true);
            return field.get(o);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void set(Object o, Object value) {
        try {
            field.setAccessible(true);
            field.set(o, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}