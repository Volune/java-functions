package net.volune.functions;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumersTest extends TestBase {
    @Test
    public void testBiConsumerApply12() throws Exception {
        Spy spy = new Spy();
        eachPair(Consumers.apply12(spy::consume));
        spy.checkConsumed(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void testBiConsumerApply21() throws Exception {
        Spy spy = new Spy();
        eachPair(Consumers.apply21(spy::consume));
        spy.checkConsumed(2, 1, 4, 3, 6, 5);
    }

    @Test
    public void testBiConsumerApply11() throws Exception {
        Spy spy = new Spy();
        eachPair(Consumers.apply11(spy::consume));
        spy.checkConsumed(1, 1, 3, 3, 5, 5);
    }

    @Test
    public void testBiConsumerApply22() throws Exception {
        Spy spy = new Spy();
        eachPair(Consumers.apply22(spy::consume));
        spy.checkConsumed(2, 2, 4, 4, 6, 6);
    }

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
        for (int i = 1; i <= LENGTH; ++i) {
            consumer.accept(i);
        }
    }

    private void eachPair(BiConsumer<Integer, Integer> consumer) {
        for (int i = 1; i <= LENGTH; ++i) {
            consumer.accept(i * 2 - 1, i * 2);
        }
    }
}