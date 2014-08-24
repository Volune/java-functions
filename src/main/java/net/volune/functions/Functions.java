package net.volune.functions;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Functions {
    //Not instantiable
    private Functions() {
    }

    public static <T, U> Consumer<? super U> bind1(BiConsumer<? super T, ? super U> consumer, T arg1) {
        return (arg2) -> consumer.accept(arg1, arg2);
    }

}
