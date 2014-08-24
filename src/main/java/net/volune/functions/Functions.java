package net.volune.functions;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Functions {
    //Not instantiable
    private Functions() {
    }

    public static <T, R> BiFunction<T, T, R> apply12(BiFunction<T, T, R> function) {
        return function;
    }

    public static <T, R> BiFunction<T, T, R> apply21(BiFunction<T, T, R> function) {
        return (arg1, arg2) -> function.apply(arg2, arg1);
    }

    public static <T, R> BiFunction<T, T, R> apply11(BiFunction<T, T, R> function) {
        return (arg1, arg2) -> function.apply(arg1, arg1);
    }

    public static <T, R> BiFunction<T, T, R> apply22(BiFunction<T, T, R> function) {
        return (arg1, arg2) -> function.apply(arg2, arg2);
    }

    public static <T, U, R, A1 extends T> Function<U, R> bind1(BiFunction<T, U, R> function, A1 arg1) {
        return (arg2) -> function.apply(arg1, arg2);
    }

    public static <T, U, R, A2 extends U> Function<T, R> bind2(BiFunction<T, U, R> function, A2 arg2) {
        return (arg1) -> function.apply(arg1, arg2);
    }

    public static <T, R, A1 extends T> Supplier<R> bind1(Function<T, R> function, A1 arg1) {
        return () -> function.apply(arg1);
    }

    public static <A, R> Supplier<R> bind11(BiFunction<? super A, ? super A, R> function, A arg) {
        return () -> function.apply(arg, arg);
    }

    public static <T, U, R, A1 extends T, A2 extends U> Supplier<R> bind12(BiFunction<T, U, R> function, A1 arg1, A2 arg2) {
        return () -> function.apply(arg1, arg2);
    }

}
