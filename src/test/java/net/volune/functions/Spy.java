package net.volune.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Spy {
    private List<Object> consumed = new ArrayList<>();
    private int resultGenerator = -1;

    public void consume(Number a1, Number a2) {
        consumed.add(a1);
        consumed.add(a2);
    }

    public String operate(String a1, String a2) {
        consumed.add(a1);
        consumed.add(a2);
        return Integer.toString(resultGenerator--, 10);
    }

    public String transform(Number a1, Number a2) {
        consumed.add(a1);
        consumed.add(a2);
        return Integer.toString(resultGenerator--, 10);
    }

    public void checkConsumed(Object... expected) {
        assertEquals("Consumed arguments", Arrays.asList(expected), consumed);
    }
}
