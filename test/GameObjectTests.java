import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fundamentals.EMNumber;
import gameobjects.GameObjectNames;
import gameobjects.Material;
import gameobjects.Multiplier;
import gameobjects.Synthesizer;

public class GameObjectTests {

    //Material Constructors

    @Test
    public void testMaterialConstructor_Type() {
        Material test = new Material(GameObjectNames.DARKMATTER);

        assertEquals(GameObjectNames.DARKMATTER, test.type());
        assertEquals(new EMNumber(), test.amount());
        assertEquals(GameObjectNames.DARKMATTER.toString(), test.name());
    }

    @Test
    public void testMaterialConstructor_TypeAndDisplayName() {
        Material test = new Material(GameObjectNames.GOLD, "Shiny Gold");

        assertEquals(GameObjectNames.GOLD, test.type());
        assertEquals(new EMNumber(), test.amount());
        assertEquals("Shiny Gold", test.name());
    }

    @Test
    public void testMaterialConstructor_Full() {
        EMNumber amt = new EMNumber(100);
        Material test = new Material(GameObjectNames.IRON, "Scrap Iron", amt);

        assertEquals(GameObjectNames.IRON, test.type());
        assertEquals(amt, test.amount());
        assertEquals("Scrap Iron", test.name());
    }

    // Synthesizer Constructors

    @Test
    public void testSynthesizerConstructor_TypeOnly() {
        Synthesizer<Material> test = new Synthesizer<Material>(
                GameObjectNames.DARKMATTER);
        Multiplier expectedMulti = new Multiplier(GameObjectNames.DARKMATTER);

        assertEquals(GameObjectNames.DARKMATTER, test.type());
        assertEquals(new EMNumber(), test.amount());
        assertEquals(expectedMulti, test.outputMultiplier());
    }

    @Test
    public void testSynthesizerConstructor_TypeAndAmount() {
        EMNumber amt = new EMNumber(500, 2);
        Synthesizer<Material> test = new Synthesizer<Material>(
                GameObjectNames.GOLD, amt);
        Multiplier expectedMulti = new Multiplier(GameObjectNames.GOLD);

        assertEquals(GameObjectNames.GOLD, test.type());
        assertEquals(amt, test.amount());
        assertEquals(expectedMulti, test.outputMultiplier());
    }

    @Test
    public void testSynthesizerConstructor_Full() {
        EMNumber amt = new EMNumber(10);
        Multiplier multi = new Multiplier(2.5, 1, GameObjectNames.IRON);
        Synthesizer<Material> test = new Synthesizer<Material>(
                GameObjectNames.IRON, amt, multi);

        assertEquals(GameObjectNames.IRON, test.type());
        assertEquals(amt, test.amount());
        assertEquals(multi, test.outputMultiplier());
    }

    // GameObjectSecondary Functions
    // (Material is chosen arbitrarily)

    @Test
    public void testCompareTo_Equal() {
        Synthesizer<Material> s1 = new Synthesizer<Material>(
                GameObjectNames.GOLD, new EMNumber(100));
        Synthesizer<Material> s2 = new Synthesizer<Material>(
                GameObjectNames.IRON, new EMNumber(100));

        assertEquals(0, s1.compareTo(s2));
    }

    @Test
    public void testCompareTo_Less() {
        Synthesizer<Material> s1 = new Synthesizer<Material>(
                GameObjectNames.GOLD, new EMNumber(50));
        Synthesizer<Material> s2 = new Synthesizer<Material>(
                GameObjectNames.GOLD, new EMNumber(100));

        assertTrue(s1.compareTo(s2) < 0);
    }

    @Test
    public void testCompareTo_Greater() {
        Synthesizer<Material> s1 = new Synthesizer<Material>(
                GameObjectNames.GOLD, new EMNumber(200));
        Synthesizer<Material> s2 = new Synthesizer<Material>(
                GameObjectNames.GOLD, new EMNumber(100));

        assertTrue(s1.compareTo(s2) > 0);
    }

    //Synthesizer is the worst example so I chose to test it lol
    @Test
    public void testNewInstance() {
        Synthesizer<Material> s1 = new Synthesizer<Material>(
                GameObjectNames.DARKMATTER, new EMNumber(100));
        Synthesizer<Material> s2 = (Synthesizer<Material>) s1.newInstance();

        assertNotSame(s1, s2);
        assertEquals(new EMNumber(), s2.amount());
    }

    @Test
    public void testNameGetter() {
        Material test = new Material(GameObjectNames.DARKMATTER, "CustomName");

        assertEquals("CustomName", test.name());
    }

    @Test
    public void testAmountGetter() {
        EMNumber initialAmount = new EMNumber(30);
        Material test = new Material(GameObjectNames.DARKMATTER, "TestMaterial",
                initialAmount);

        assertEquals(initialAmount, test.amount());
    }

    @Test
    public void testSetAmount() {
        Material test = new Material(GameObjectNames.DARKMATTER, "TestMaterial",
                new EMNumber(30));
        EMNumber newAmount = new EMNumber(50);

        test.setAmount(newAmount);

        assertEquals(newAmount, test.amount());
    }

    @Test
    public void testSetAmountAlias() {
        EMNumber newAmount = new EMNumber(50);
        Material test = new Material(GameObjectNames.DARKMATTER, "TestMaterial",
                new EMNumber(30));

        test.setAmount(newAmount);
        newAmount.clear();

        assertNotEquals(newAmount, test.amount());
        assertEquals(new EMNumber(50), test.amount());
    }

    @Test
    public void testTypeGetter() {
        Material test = new Material(GameObjectNames.DARKMATTER, "TestMaterial",
                new EMNumber(30));

        assertEquals(GameObjectNames.DARKMATTER, test.type());
    }

    @Test
    public void testSetType() {
        Material test = new Material(GameObjectNames.DARKMATTER, "TestMaterial",
                new EMNumber(30));

        test.setType(GameObjectNames.GOLD);

        assertEquals(GameObjectNames.GOLD, test.type());
    }

    // Material Functions

    @Test
    public void testMaterialAdd() {
        Material test = new Material(GameObjectNames.GOLD, "TestMaterial",
                new EMNumber(100));
        test.add(new EMNumber(50));

        assertEquals(new EMNumber(150), test.amount());
    }

    @Test
    public void testMaterialSubtract_Success() {
        Material test = new Material(GameObjectNames.GOLD, "TestMaterial",
                new EMNumber(100));
        boolean result = test.subtract(new EMNumber(40));

        assertTrue(result);
        assertEquals(new EMNumber(60), test.amount());
    }

    @Test
    public void testMaterialSubtract_Fail() {
        Material test = new Material(GameObjectNames.GOLD, "TestMaterial",
                new EMNumber(100));
        boolean result = test.subtract(new EMNumber(200));

        assertFalse(result);
        assertEquals(new EMNumber(100), test.amount());
    }

    @Test
    public void testMaterialMultiply() {
        Material test = new Material(GameObjectNames.GOLD, "TestMaterial",
                new EMNumber(10));
        test.multiply(new EMNumber(5));

        assertEquals(new EMNumber(50), test.amount());
    }

    @Test
    public void testMaterialDivide() {
        Material test = new Material(GameObjectNames.GOLD, "TestMaterial",
                new EMNumber(100));
        test.divide(new EMNumber(4));

        assertEquals(new EMNumber(25), test.amount());
    }

    @Test
    public void testMaterialName() {
        Material test = new Material(GameObjectNames.DARKMATTER, "TestMaterial",
                new EMNumber(30));

        assertEquals("TestMaterial", test.name());
    }
}