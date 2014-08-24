package net.volune.functions;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spy {
    private List<Number> consumed = new ArrayList<>();

    public void consume(Number a1, Number a2) {
        consumed.add(a1);
        consumed.add(a2);
    }

    public void checkConsumed(Number... expected) {
        Assert.assertEquals("Consumed arguments", Arrays.asList(expected), consumed);
    }
}
