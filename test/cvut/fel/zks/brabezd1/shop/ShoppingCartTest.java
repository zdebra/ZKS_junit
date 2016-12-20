package cvut.fel.zks.brabezd1.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ShoppingCartTest {

    @Test
    void addItem() {

        ShoppingCart shoppingCart = new ShoppingCart();
        StandardItem item = new StandardItem(1,"asd",23, "somecat", 12);
        shoppingCart.addItem(item);

        assertTrue(shoppingCart.getCartItems().contains(item));

    }

    @Test
    void removeItem() {

        ShoppingCart shoppingCart = new ShoppingCart();
        StandardItem item = new StandardItem(1,"asd",23, "somecat", 12);
        shoppingCart.addItem(item);

        assertFalse(shoppingCart.getCartItems().isEmpty());

        shoppingCart.removeItem(item.getID());
        assertTrue(shoppingCart.getCartItems().isEmpty());


    }


    @Test
    void getTotalPrice() {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new StandardItem(1,"asd",23, "somecat", 12));
        shoppingCart.addItem(new DiscountedItem(2,"test",100,"XY",10,"12.12.2015", "24.12.2017"));
        shoppingCart.addItem(new DiscountedItem(3,"test",200,"XY",10,"12.12.2015", "24.12.2017"));

        assertEquals(180+90+23,shoppingCart.getTotalPrice());

    }

}