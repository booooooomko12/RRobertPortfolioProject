import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber2;
import fundamentals.EMNumber;

public class EMNumberTests {

    private static boolean isMantissaEqual(EMNumber n, double target) {
        return Math.abs(n.mantissa() - target) < (0.00001);
    }

    @Test
    public void testConstructors() {
        EMNumber test = new EMNumber();
        assertEquals(true, isMantissaEqual(test, 0.0));
        assertEquals(true, test.exponent() == 0);

        EMNumber testNN = new EMNumber(new NaturalNumber2("1234567890"));
        assertEquals(true, isMantissaEqual(testNN, 1.23456));
        assertEquals(9, testNN.exponent());

        EMNumber testInt = new EMNumber(1234067890);
        assertEquals(true, isMantissaEqual(testInt, 1.23406));
        assertEquals(9, testInt.exponent());

        EMNumber testManual = new EMNumber(1.23406, 9);
        assertEquals(true, isMantissaEqual(testManual, 1.23406));
        assertEquals(9, testManual.exponent());

        EMNumber testEM = new EMNumber(testInt);
        assertEquals(true, isMantissaEqual(testEM, 1.23406));
        assertEquals(9, testEM.exponent());
    }

    @Test
    public void testKernels() {
        EMNumber test = new EMNumber(new NaturalNumber2("9999999999"));
        assertEquals(true, isMantissaEqual(test, 9.99999));
        assertEquals(true, test.exponent() == 9);

        /*
         * The behavior of this function is intended to do nothing if the
         * desired number to add is too small, and replace `this` when the
         * desired number to add is beyond the sig-figs of `this`.
         *
         * It's technically not correct, but when the amount added is too
         * negligible or massive, it's better to have it work this way later to
         * save time.
         */

        test.add(new EMNumber(1));
        assertEquals(true, isMantissaEqual(test, 9.99999));
        assertEquals(true, test.exponent() == 9);
        test.add(new EMNumber(new NaturalNumber2("5555555555555555")));
        assertEquals(true, isMantissaEqual(test, 5.55555));
        assertEquals(true, test.exponent() == 15);

        //Test equal exponent math + overflow
        test.add(test);
        assertEquals(true, isMantissaEqual(test, 1.11111));
        assertEquals(true, test.exponent() == 16);

    }
}
