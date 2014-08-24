package net.volune.functions;

import org.junit.Test;

import java.util.Arrays;

public class ConsumersTest {
    @Test
    public void testBiConsumerBind1() throws Exception {
        Spy spy = new Spy();
        Arrays.asList(1, 2, 3).forEach(Consumers.bind1(spy::consume, 0));
        spy.checkConsumed(0, 1, 0, 2, 0, 3);
    }

    @Test
    public void testBiConsumerBind2() throws Exception {
        Spy spy = new Spy();
        Arrays.asList(1, 2, 3).forEach(Consumers.bind2(spy::consume, 0));
        spy.checkConsumed(1, 0, 2, 0, 3, 0);
    }
}