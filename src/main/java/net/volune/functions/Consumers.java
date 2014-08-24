package net.volune.functions;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Provides utility functions for method references that are intended not to return anything.
 */
public class Consumers {
    //Not instantiable
    private Consumers() {
    }

    /**
     * Reorder arguments of the given method reference <code>arg1,arg2 -&gt; arg1,arg2</code>.
     * <p>
     * Does actually nothing because the arguments are still used in the same order.
     *
     * @param consumer the method reference to be wrapped
     * @return the given consumer
     */
    public static <T> BiConsumer<T, T> apply12(BiConsumer<T, T> consumer) {
        return consumer;
    }

    /**
     * Reorder arguments of the given method reference <code>arg1,arg2 -&gt; arg2,arg1</code>.
     * <p>
     * Arguments are swapped.
     *
     * @param consumer the method reference to be wrapped
     * @return a new method reference that calls the given one with rearranged arguments
     */
    public static <T> BiConsumer<T, T> apply21(BiConsumer<T, T> consumer) {
        return (arg1, arg2) -> consumer.accept(arg2, arg1);
    }

    /**
     * Reorder arguments of the given method reference <code>arg1,arg2 -&gt; arg1,arg1</code>.
     * <p>
     * The second argument is ignored.
     *
     * @param consumer the method reference to be wrapped
     * @return a new method reference that calls the given one with rearranged arguments
     */
    public static <T> BiConsumer<T, T> apply11(BiConsumer<T, T> consumer) {
        return (arg1, arg2) -> consumer.accept(arg1, arg1);
    }

    /**
     * Reorder arguments of the given method reference <code>arg1,arg2 -&gt; arg2,arg2</code>.
     * <p>
     * The first argument is ignored.
     *
     * @param consumer the method reference to be wrapped
     * @return a new method reference that calls the given one with rearranged arguments
     */
    public static <T> BiConsumer<T, T> apply22(BiConsumer<T, T> consumer) {
        return (arg1, arg2) -> consumer.accept(arg2, arg2);
    }

    /**
     * Bind a given value as the first argument of a given method reference.
     *
     * @param consumer the method reference to be wrapped
     * @param arg1     the value to bind as the first argument
     * @return a new method reference that calls the given one with a bound argument
     */
    public static <T, U, A1 extends T> Consumer<U> bind1(BiConsumer<T, U> consumer, A1 arg1) {
        return (arg2) -> consumer.accept(arg1, arg2);
    }

    /**
     * Bind a given value as the second argument of a given method reference.
     *
     * @param consumer the method reference to be wrapped
     * @param arg2     the value to bind as the second argument
     * @return a new method reference that calls the given one with a bound argument
     */
    public static <T, U, A2 extends U> Consumer<T> bind2(BiConsumer<T, U> consumer, A2 arg2) {
        return (arg1) -> consumer.accept(arg1, arg2);
    }

}
