package io.github.lumine1909.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodAccessor {
    private Method method = null;
    public MethodAccessor(Class<?> clazz, Class<?> returnType, Class<?>... arguments) {
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.getReturnType().equals(returnType) && m.getParameterCount() == arguments.length && Arrays.equals(m.getParameterTypes(), arguments)) {
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
            throw new RuntimeException(e);
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
            method.setAccessible(true);
            return method.invoke(object, arguments);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
