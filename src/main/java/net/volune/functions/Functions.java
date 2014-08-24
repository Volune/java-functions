package net.volune.functions;

import java.util.function.*;

public class Functions {
    //Not instantiable
    private Functions() {
    }

    public static <T, U, R, A1 extends T> Function<U, R> bind1(BiFunction<T, U, R> function, A1 arg1) {
        return (arg2) -> function.apply(arg1, arg2);
    }

    public static <T, U, R, A2 extends U> Function<T, R> bind2(BiFunction<T, U, R> function, A2 arg2) {
        return (arg1) -> function.apply(arg1, arg2);
    }

    public static <T, U, R, A1 extends T, A2 extends U> Supplier<R> bind12(BiFunction<T, U, R> function, A1 arg1, A2 arg2) {
        return () -> function.apply(arg1, arg2);
    }

}
