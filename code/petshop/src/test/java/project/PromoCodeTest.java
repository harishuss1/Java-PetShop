package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class PromoCodeTest {

    @Test
    public void testGetCode() {
        PromoCode promo = new PromoCode("CODE123", 10.0);

        // get right code
        assertEquals("CODE123", promo.getCode());

        // get wrong code
        assertNotEquals("notCODE123", promo.getCode());
    }

    @Test
    public void testSetCode() {
        PromoCode promo = new PromoCode("CODE123", 10.0);

        promo.setCode("newCODE123");

        // get right code
        assertEquals("newCODE123", promo.getCode());

        // get old code
        assertNotEquals("CODE123", promo.getCode());
    }

    @Test
    public void testGetValue() {
        PromoCode promo = new PromoCode("CODE123", 10.0);

        // get right value
        assertEquals(10.0, promo.getValue(), 0.00001);

        // get wrong value
        assertNotEquals(12.0, promo.getValue(), 0.00001);
    }

    @Test
    public void testSetValue() {
        PromoCode promo = new PromoCode("CODE123", 10.0);

        promo.setValue(99.0);

        // get right value
        assertEquals(99.0, promo.getValue(), 0.00001);

        // get old value
        assertNotEquals(10.0, promo.getValue(), 0.00001);
    }

}
