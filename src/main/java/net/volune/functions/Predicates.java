package net.volune.functions;

import java.util.function.*;

public class Predicates {
    //Not instantiable
    private Predicates() {
    }

    public static <T, U, R, A1 extends T> Predicate<U> bind1(BiPredicate<T, U> predicate, A1 arg1) {
        return (arg2) -> predicate.test(arg1, arg2);
    }

    public static <T, U, R, A2 extends U> Predicate<T> bind2(BiPredicate<T, U> predicate, A2 arg2) {
        return (arg1) -> predicate.test(arg1, arg2);
    }

    public static <T, R, A1 extends T> BooleanSupplier bind1(Predicate<T> predicate, A1 arg1) {
        return () -> predicate.test(arg1);
    }

    public static <T, U, R, A1 extends T, A2 extends U> BooleanSupplier bind12(BiPredicate<T, U> predicate, A1 arg1, A2 arg2) {
        return () -> predicate.test(arg1, arg2);
    }

}
