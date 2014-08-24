package net.volune.functions;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Provides utility functions for method references that are intended to return an Object.
 */
public class Functions {
    //Not instantiable
    private Functions() {
    }

    /**
     * Reorder arguments of the given method reference <code>arg1,arg2 -&gt; arg1,arg2</code>.
     * <p>
     * Does actually nothing because the arguments are still used in the same order.
     *
     * @param function the method reference to be wrapped
     * @return the given consumer
     */
    public static <T, R> BiFunction<T, T, R> apply12(BiFunction<T, T, R> function) {
        return function;
    }

    /**
     * Reorder arguments of the given method reference <code>arg1,arg2 -&gt; arg2,arg1</code>.
     * <p>
     * Arguments are swapped
     *
     * @param function the method reference to be wrapped
     * @return a new method reference that calls the given one with rearranged arguments
     */
    public static <T, R> BiFunction<T, T, R> apply21(BiFunction<T, T, R> function) {
        return (arg1, arg2) -> function.apply(arg2, arg1);
    }

    /**
     * Reorder arguments of the given method reference <code>arg1,arg2 -&gt; arg1,arg1</code>.
     * <p>
     * The second argument is ignored.
     *
     * @param function the method reference to be wrapped
     * @return a new method reference that calls the given one with rearranged arguments
     */
    public static <T, R> BiFunction<T, T, R> apply11(BiFunction<T, T, R> function) {
        return (arg1, arg2) -> function.apply(arg1, arg1);
    }

    /**
     * Reorder arguments of the given method reference <code>arg1,arg2 -&gt; arg2,arg2</code>.
     * <p>
     * The first argument is ignored.
     *
     * @param function the method reference to be wrapped
     * @return a new method reference that calls the given one with rearranged arguments
     */
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
