package net.volune.functions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class PredicatesTest extends TestBase {
    @Test
    public void testBiPredicateApply12() throws Exception {
        Spy spy = new Spy();
        mapPair(Predicates.apply12(spy::test2));
        spy.checkConsumed(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void testBiPredicateApply21() throws Exception {
        Spy spy = new Spy();
        mapPair(Predicates.apply21(spy::test2));
        spy.checkConsumed(2, 1, 4, 3, 6, 5);
    }

    @Test
    public void testBiPredicateApply11() throws Exception {
        Spy spy = new Spy();
        mapPair(Predicates.apply11(spy::test2));
        spy.checkConsumed(1, 1, 3, 3, 5, 5);
    }

    @Test
    public void testBiPredicateApply22() throws Exception {
        Spy spy = new Spy();
        mapPair(Predicates.apply22(spy::test2));
        spy.checkConsumed(2, 2, 4, 4, 6, 6);
    }

    @Test
    public void testBiPredicateBind1() throws Exception {
        Spy spy = new Spy();
        map(Predicates.bind1(spy::test2, 0));
        spy.checkConsumed(0, 1, 0, 2, 0, 3);
    }

    @Test
    public void testBiPredicateBind2() throws Exception {
        Spy spy = new Spy();
        map(Predicates.bind2(spy::test2, 0));
        spy.checkConsumed(1, 0, 2, 0, 3, 0);
    }

    @Test
    public void testBiPredicateBind12() throws Exception {
        Spy spy = new Spy();
        generate(Predicates.bind12(spy::test2, 8, 9));
        spy.checkConsumed(8, 9, 8, 9, 8, 9);
    }

    @Test
    public void testBiPredicateBind11() throws Exception {
        Spy spy = new Spy();
        generate(Predicates.bind11(spy::test2, 7));
        spy.checkConsumed(7, 7, 7, 7, 7, 7);
    }

    @Test
    public void testPredicateBind1() throws Exception {
        Spy spy = new Spy();
        generate(Predicates.bind1(spy::test1, 7));
        spy.checkConsumed(7, 7, 7);
    }

    private void map(Predicate<Integer> predicate) {
        List<Boolean> results = new ArrayList<>();
        for (int i = 1; i <= LENGTH; ++i) {
            results.add(predicate.test(i));
        }
        assertEquals(asList(false, true, false), results);
    }

    private void mapPair(BiPredicate<Integer, Integer> predicate) {
        List<Boolean> results = new ArrayList<>();
        for (int i = 1; i <= LENGTH; ++i) {
            results.add(predicate.test(i * 2 - 1, i * 2));
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