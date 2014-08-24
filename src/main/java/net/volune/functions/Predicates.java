package net.volune.functions;

import java.util.function.*;

/**
 * Provides utility functions for method references that are intended to return a boolean.
 */
public class Predicates {
    //Not instantiable
    private Predicates() {
    }

    /**
     * Reorder arguments of the given method reference <code>arg1,arg2 -> arg1,arg2</code>.
     *
     * Does actually nothing because the arguments are still used in the same order.
     * @param predicate the method reference to be wrapped
     * @return the given consumer
     */
    public static <T> BiPredicate<T, T> apply12(BiPredicate<T, T> predicate) {
        return predicate;
    }

    public static <T> BiPredicate<T, T> apply21(BiPredicate<T, T> predicate) {
        return (arg1, arg2) -> predicate.test(arg2, arg1);
    }

    public static <T> BiPredicate<T, T> apply11(BiPredicate<T, T> predicate) {
        return (arg1, arg2) -> predicate.test(arg1, arg1);
    }

    public static <T> BiPredicate<T, T> apply22(BiPredicate<T, T> predicate) {
        return (arg1, arg2) -> predicate.test(arg2, arg2);
    }

    public static <T, U, A1 extends T> Predicate<U> bind1(BiPredicate<T, U> predicate, A1 arg1) {
        return (arg2) -> predicate.test(arg1, arg2);
    }

    public static <T, U, A2 extends U> Predicate<T> bind2(BiPredicate<T, U> predicate, A2 arg2) {
        return (arg1) -> predicate.test(arg1, arg2);
    }

    public static <T, A1 extends T> BooleanSupplier bind1(Predicate<T> predicate, A1 arg1) {
        return () -> predicate.test(arg1);
    }

    public static <A> BooleanSupplier bind11(BiPredicate<? super A, ? super A> predicate, A arg) {
        return () -> predicate.test(arg, arg);
    }

    public static <T, U, A1 extends T, A2 extends U> BooleanSupplier bind12(BiPredicate<T, U> predicate, A1 arg1, A2 arg2) {
        return () -> predicate.test(arg1, arg2);
    }

}
