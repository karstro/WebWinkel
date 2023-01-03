package web.winkel.webwinkel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class WebwinkelTests {

    private final Webwinkel webwinkel = new Webwinkel();

    @Test
    void testAssert() {
        Assertions.assertTrue(true);
    }

    @Test
    void getCustomerTest() {
        String customer = webwinkel.getObject("Customer", 10);
        Assertions.assertEquals("10: Person1", customer);
    }

}