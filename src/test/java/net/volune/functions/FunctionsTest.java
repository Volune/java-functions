package net.volune.functions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class FunctionsTest extends TestBase {
    @Test
    public void testBiFunctionBind1() throws Exception {
        Spy spy = new Spy();
        map(Functions.bind1(spy::transform2, 0));
        spy.checkConsumed(0, 1, 0, 2, 0, 3);
    }

    @Test
    public void testBiFunctionBind2() throws Exception {
        Spy spy = new Spy();
        map(Functions.bind2(spy::transform2, 0));
        spy.checkConsumed(1, 0, 2, 0, 3, 0);
    }

    @Test
    public void testBiFunctionBind12() throws Exception {
        Spy spy = new Spy();
        generate(Functions.bind12(spy::transform2, 8, 9));
        spy.checkConsumed(8, 9, 8, 9, 8, 9);
    }

    @Test
    public void testFunctionBind1() throws Exception {
        Spy spy = new Spy();
        generate(Functions.bind1(spy::transform1, 7));
        spy.checkConsumed(7, 7, 7);
    }

    @Test
    public void testBinaryOperatorBind12() throws Exception {
        Spy spy = new Spy();
        BinaryOperator<String> operator = spy::operate2;
        generate(Functions.bind12(operator, "a", "b"));
        spy.checkConsumed("a", "b", "a", "b", "a", "b");
    }

    @Test
    public void testUnaryOperatorBind12() throws Exception {
        Spy spy = new Spy();
        UnaryOperator<String> operator = spy::operate1;
        generate(Functions.bind1(operator, "c"));
        spy.checkConsumed("c", "c", "c");
    }

    private void map(Function<Integer, String> function) {
        List<String> results = new ArrayList<>();
        for (int i = 1; i <= LENGTH; ++i) {
            results.add(function.apply(i));
        }
        assertEquals(asList("-1", "-2", "-3"), results);
    }

    private void generate(Supplier<String> supplier) {
        List<String> results = new ArrayList<>();
        for (int i = 1; i <= LENGTH; ++i) {
            results.add(supplier.get());
        }
        assertEquals(asList("-1", "-2", "-3"), results);
    }
}