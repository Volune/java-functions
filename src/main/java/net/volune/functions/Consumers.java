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

    public static <T> BiConsumer<T, T> apply12(BiConsumer<T, T> consumer) {
        return consumer;
    }

    public static <T> BiConsumer<T, T> apply21(BiConsumer<T, T> consumer) {
        return (arg1, arg2) -> consumer.accept(arg2, arg1);
    }

    public static <T> BiConsumer<T, T> apply11(BiConsumer<T, T> consumer) {
        return (arg1, arg2) -> consumer.accept(arg1, arg1);
    }

    public static <T> BiConsumer<T, T> apply22(BiConsumer<T, T> consumer) {
        return (arg1, arg2) -> consumer.accept(arg2, arg2);
    }

    public static <T, U, A1 extends T> Consumer<U> bind1(BiConsumer<T, U> consumer, A1 arg1) {
        return (arg2) -> consumer.accept(arg1, arg2);
    }

    public static <T, U, A2 extends U> Consumer<T> bind2(BiConsumer<T, U> consumer, A2 arg2) {
        return (arg1) -> consumer.accept(arg1, arg2);
    }

}
