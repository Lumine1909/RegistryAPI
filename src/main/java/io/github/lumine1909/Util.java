package io.github.lumine1909;

import java.util.Optional;

public class Util {
    public static Optional<?> wrapOptional(Object value) {
        return Optional.ofNullable(value);
    }
    public static Object unWrapOptional(Optional<?> optional) {
        return optional.orElse(null);
    }
}
