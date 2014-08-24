package net.volune.functions;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Consumers {
    //Not instantiable
    private Consumers() {
    }

    public static <T, U, A1 extends T> Consumer<U> bind1(BiConsumer<T, U> consumer, A1 arg1) {
        return (arg2) -> consumer.accept(arg1, arg2);
    }

    public static <T, U, A2 extends U> Consumer<T> bind2(BiConsumer<T, U> consumer, A2 arg2) {
        return (arg1) -> consumer.accept(arg1, arg2);
    }

}
