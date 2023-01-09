package web.winkel.webwinkel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class WebwinkelTests {

    private final Webwinkel webwinkel = new Webwinkel();

    @Test
    void whenCustomerIdExists_ThenGetCustomer() {
        String customer = webwinkel.getObject("Customer", 10);
        Assertions.assertEquals("10: Person1", customer);
    }

    @Test
    void whenProductIdExists_ThenGetProduct() {
        String product = webwinkel.getObject("Product", 1);
        Assertions.assertEquals("1: 10 - 3 TestProduct", product);
    }

    @Test
    void whenCartItemIdExists_ThenGetCartItem() {
        String cartitem = webwinkel.getObject("CartItem", 1);
        Assertions.assertEquals("1: 3 TestProduct for Person1", cartitem);
    }

    @Test
    void whenOrderItemIdExists_ThenGetOrderItem() {
        String orderitem = webwinkel.getObject("OrderItem", 1);
        Assertions.assertEquals("1: 2 TestProduct", orderitem);
    }

    @Test
    void whenOrderIdExists_ThenGetOrder() {
        String order = webwinkel.getObject("Order", 1);
        Assertions.assertEquals("1 {\n  1: 2 TestProduct\n}", order);
    }

    @Test
    void whenNegativeCustomerId_ThenGetFailureMessage() {
        String customer = webwinkel.getObject("Customer", -1);
        Assertions.assertEquals("Customer with id -1 does not exist.", customer);
    }

    @Test
    void whenObjectTypeDoesNotExist_ThenGetFailureMessage() {
        String customer = webwinkel.getObject("Cuzztomer", 10);
        Assertions.assertEquals("Object type \"Cuzztomer\" not recognized", customer);
    }

}