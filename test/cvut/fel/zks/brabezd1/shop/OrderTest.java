package cvut.fel.zks.brabezd1.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zb on 20/12/2016.
 */
class OrderTest {

    @Test
    void testConstructor() {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new StandardItem(1,"asd",23, "somecat", 12));
        Order order = new Order(shoppingCart, "pepik", "some address");
        assertEquals("pepik",order.getCustomerName());
        assertEquals("some address",order.getCustomerAddress());
        assertEquals(1,order.getItems().size());

    }

}