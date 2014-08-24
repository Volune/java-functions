package net.volune.functions;

import org.junit.Test;

import java.util.function.Consumer;

public class ConsumersTest extends TestBase {
    @Test
    public void testBiConsumerBind1() throws Exception {
        Spy spy = new Spy();
        each(Consumers.bind1(spy::consume, 0));
        spy.checkConsumed(0, 1, 0, 2, 0, 3);
    }

    @Test
    public void testBiConsumerBind2() throws Exception {
        Spy spy = new Spy();
        each(Consumers.bind2(spy::consume, 0));
        spy.checkConsumed(1, 0, 2, 0, 3, 0);
    }

    private void each(Consumer<Integer> consumer) {
        for(int i = 1; i <= LENGTH; ++i) {
            consumer.accept(i);
        }
    }
}