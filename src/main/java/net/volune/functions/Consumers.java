package net.volune.functions;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Consumers {
    //Not instantiable
    private Consumers() {
    }

    public static <T, U> Consumer<? super U> bind1(BiConsumer<? super T, ? super U> consumer, T arg1) {
        return (arg2) -> consumer.accept(arg1, arg2);
    }

    public static <T, U> Consumer<? super T> bind2(BiConsumer<? super T, ? super U> consumer, U arg2) {
        return (arg1) -> consumer.accept(arg1, arg2);
    }

}
