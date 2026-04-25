import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber2;
import fundamentals.EMNumber;

public class EMNumberTests {

    private static boolean isMantissaEqual(EMNumber n, double target) {
        return Math.abs(n.mantissa() - target) < (0.00001);
    }

    // Constructors

    @Test
    public void testConstructor_Default() {
        EMNumber test = new EMNumber();
        assertTrue(isMantissaEqual(test, 0.0));
        assertEquals(0, test.exponent());
    }

    @Test
    public void testConstructor_NaturalNumber() {
        EMNumber testNN = new EMNumber(new NaturalNumber2("1234567890"));
        assertTrue(isMantissaEqual(testNN, 1.23456));
        assertEquals(9, testNN.exponent());
    }

    @Test
    public void testConstructor_Int() {
        EMNumber testInt = new EMNumber(1234067890);
        assertTrue(isMantissaEqual(testInt, 1.23406));
        assertEquals(9, testInt.exponent());
    }

    @Test
    public void testConstructor_Manual() {
        EMNumber testManual = new EMNumber(1.23406, 9);
        assertTrue(isMantissaEqual(testManual, 1.23406));
        assertEquals(9, testManual.exponent());
    }

    @Test
    public void testConstructor_Copy() {
        EMNumber original = new EMNumber(1.23406, 9);
        EMNumber copy = new EMNumber(original);
        assertTrue(isMantissaEqual(copy, 1.23406));
        assertEquals(9, copy.exponent());
    }

    // Kernels

    /*
     * The behavior of add is intended to do nothing if the desired number to
     * add is too small, and replace `this` when the desired number to add is
     * beyond the sig-figs of `this`.
     *
     * It's technically not correct, but when the amount added is too negligible
     * or massive, it's better to have it work this way later to save time.
     */

    @Test
    public void testAdd_NormalCase() {
        EMNumber test = new EMNumber(150);
        test.add(new EMNumber(50));

        assertEquals(new EMNumber(200), test);

    }

    @Test
    public void testAdd_SmallValue() {
        EMNumber test = new EMNumber(new NaturalNumber2("23472357"));
        test.add(new EMNumber(1));

        assertTrue(isMantissaEqual(test, 2.3472357));
        assertEquals(7, test.exponent());
    }

    @Test
    public void testAdd_LargeValue() {
        EMNumber test = new EMNumber(new NaturalNumber2("23472357"));
        test.add(new EMNumber(new NaturalNumber2("5555555555555555")));

        assertTrue(isMantissaEqual(test, 5.55555));
        assertEquals(15, test.exponent());
    }

    @Test
    public void testAdd_EqualExponentOverflow() {
        EMNumber test = new EMNumber(5.55555, 15);
        test.add(new EMNumber(5.55555, 15));

        assertTrue(isMantissaEqual(test, 1.11111));
        assertEquals(16, test.exponent());
    }

    // Standard

    // --- Standard Component Method Tests ---

    @Test
    public void testClear() {
        EMNumber test = new EMNumber(5.5, 10);
        test.clear();

        assertTrue(isMantissaEqual(test, 0.0));
        assertEquals(0, test.exponent());
    }

    @Test
    public void testNewInstance() {
        EMNumber test = new EMNumber(5.5, 10);
        EMNumber empty = test.newInstance();

        assertTrue(isMantissaEqual(empty, 0.0));
        assertEquals(0, empty.exponent());
        assertNotSame(test, empty);
    }

    @Test
    public void testTransferFrom() {
        EMNumber source = new EMNumber(1.23, 5);
        EMNumber receiver = new EMNumber();
        receiver.transferFrom(source);

        assertTrue(isMantissaEqual(receiver, 1.23));
        assertEquals(5, receiver.exponent());
        assertTrue(isMantissaEqual(source, 0.0));
        assertEquals(0, source.exponent());
    }

    @Test
    public void testCopyFrom() {
        EMNumber source = new EMNumber(7.89, 12);
        EMNumber receiver = new EMNumber();
        receiver.copyFrom(source);

        assertTrue(isMantissaEqual(receiver, 7.89));
        assertEquals(12, receiver.exponent());
        assertTrue(isMantissaEqual(source, 7.89));
        assertEquals(12, source.exponent());
    }
}
