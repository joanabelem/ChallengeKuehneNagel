package utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationsTest {

    @Test
    public void isCurrencyValidTest_ValidCurrency(){

        assertTrue(Validations.isCurrencyValid("EUR"));
    }

    @Test
    public void isCurrencyValidTest_InvalidCurrency(){

        assertFalse(Validations.isCurrencyValid("eur"));
        assertFalse(Validations.isCurrencyValid("3"));
        assertFalse(Validations.isCurrencyValid("test"));
    }
}
