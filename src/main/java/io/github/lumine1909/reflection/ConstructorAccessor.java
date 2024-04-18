package io.github.lumine1909.reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class ConstructorAccessor {
    Constructor<?> constructor;
    public ConstructorAccessor(Class<?> clazz, int index, Class<?>... arguments) {
        for (Constructor<?> c : clazz.getConstructors()) {
            if (Arrays.equals(c.getParameterTypes(), arguments)) {
                if (index > 0) {
                    index--;
                    continue;
                }
                constructor = c;
                constructor.setAccessible(true);
                return;
            }
        }
    }
    public ConstructorAccessor(Class<?> clazz, Class<?>... arguments) {
        try {
            constructor = clazz.getConstructor(arguments);
            constructor.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Constructor<?> getConstructor() {
        if (constructor == null) {
            throw new RuntimeException();
        }
        return constructor;
    }
    public Object newInstance(Object... arguments) {
        try {
            constructor.setAccessible(true);
            return constructor.newInstance(arguments);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}