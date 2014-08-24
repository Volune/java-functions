package net.volune.functions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class PredicatesTest extends TestBase {
    @Test
    public void testBiPredicateBind1() throws Exception {
        Spy spy = new Spy();
        map(Predicates.bind1(spy::test, 0));
        spy.checkConsumed(0, 1, 0, 2, 0, 3);
    }

    @Test
    public void testBiPredicateBind2() throws Exception {
        Spy spy = new Spy();
        map(Predicates.bind2(spy::test, 0));
        spy.checkConsumed(1, 0, 2, 0, 3, 0);
    }

    @Test
    public void testBiPredicateBind12() throws Exception {
        Spy spy = new Spy();
        generate(Predicates.bind12(spy::test, 8, 9));
        spy.checkConsumed(8, 9, 8, 9, 8, 9);
    }

    private void map(Predicate<Integer> predicate) {
        List<Boolean> results = new ArrayList<>();
        for (int i = 1; i <= LENGTH; ++i) {
            results.add(predicate.test(i));
        }
        assertEquals(asList(false, true, false), results);
    }

    private void generate(BooleanSupplier supplier) {
        List<Boolean> results = new ArrayList<>();
        for (int i = 1; i <= LENGTH; ++i) {
            results.add(supplier.getAsBoolean());
        }
        assertEquals(asList(false, true, false), results);
    }
}