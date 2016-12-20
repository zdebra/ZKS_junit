package cvut.fel.zks.brabezd1.storage;

import cvut.fel.zks.brabezd1.shop.StandardItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zb on 20/12/2016.
 */
class ItemStockTest {
    @Test
    void toStringTest() {

        ItemStock itemStock = new ItemStock(new StandardItem(1,"asd",23, "somecat", 12));
        assertEquals("STOCK OF ITEM:  Item   ID 1   NAME asd   CATEGORY somecat   PRICE 23.0   LOYALTY POINTS 12    PIECES IN STORAGE: 0",itemStock.toString());

    }

    @Test
    void increaseItemCount() {

        ItemStock itemStock = new ItemStock(new StandardItem(1,"asd",23, "somecat", 12));
        itemStock.increaseItemCount(10);
        assertEquals(10,itemStock.getCount());
        itemStock.increaseItemCount(2);
        assertEquals(12, itemStock.getCount());

    }

    @Test
    void decreaseItemCount() {
        ItemStock itemStock = new ItemStock(new StandardItem(1,"asd",23, "somecat", 12));
        itemStock.decreaseItemCount(10);
        assertEquals(0,itemStock.getCount());
        itemStock.increaseItemCount(6);
        assertEquals(6, itemStock.getCount());
        itemStock.decreaseItemCount(1);
        assertEquals(5, itemStock.getCount());
    }

}