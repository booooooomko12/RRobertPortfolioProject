import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fundamentals.EMNumber;

public class EMNumberTests {
    @Test
    public void testConstructors() {
        EMNumber test = new EMNumber();
        assertEquals(true, Math.abs(test.mantissa()) < 0.00001);
    }
}
