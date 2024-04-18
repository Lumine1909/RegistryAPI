package io.github.lumine1909.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodAccessor {
    private Method method = null;
    public MethodAccessor(Class<?> clazz, int index, Class<?> returnType, Class<?>... arguments) {
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.getReturnType().equals(returnType) && Arrays.equals(m.getParameterTypes(), arguments)) {
                if (index > 0) {
                    index--;
                    continue;
                }
                method = m;
                method.setAccessible(true);
                return;
            }
        }
    }
    public MethodAccessor(Class<?> clazz, String name, Class<?>... arguments) {
        try {
            method = clazz.getDeclaredMethod(name, arguments);
            method.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Method getMethod() {
        if (method == null) {
            throw new RuntimeException();
        }
        return method;
    }
    public Object invoke(Object object, Object... arguments) {
        try {
            return method.invoke(object, arguments);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
