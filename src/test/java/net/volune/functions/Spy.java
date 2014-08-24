package net.volune.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Spy {
    private List<Object> consumed = new ArrayList<>();
    private int resultGenerator = -1;
    private boolean booleanResultGenerator = false;

    public void consume(Number a1, Number a2) {
        consumed.add(a1);
        consumed.add(a2);
    }

    public String operate1(String a1) {
        consumed.add(a1);
        return Integer.toString(resultGenerator--, 10);
    }

    public String operate2(String a1, String a2) {
        consumed.add(a1);
        consumed.add(a2);
        return Integer.toString(resultGenerator--, 10);
    }

    public String transform1(Number a1) {
        consumed.add(a1);
        return Integer.toString(resultGenerator--, 10);
    }

    public String transform2(Number a1, Number a2) {
        consumed.add(a1);
        consumed.add(a2);
        return Integer.toString(resultGenerator--, 10);
    }

    public boolean test1(Number a1) {
        consumed.add(a1);
        boolean result = booleanResultGenerator;
        booleanResultGenerator = !booleanResultGenerator;
        return result;
    }

    public boolean test2(Number a1, Number a2) {
        consumed.add(a1);
        consumed.add(a2);
        boolean result = booleanResultGenerator;
        booleanResultGenerator = !booleanResultGenerator;
        return result;
    }

    public void checkConsumed(Object... expected) {
        assertEquals("Consumed arguments", Arrays.asList(expected), consumed);
    }
}
