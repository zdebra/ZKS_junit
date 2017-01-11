package cvut.fel.zks.brabezd1.archive;

import cvut.fel.zks.brabezd1.shop.Item;
import cvut.fel.zks.brabezd1.shop.StandardItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zb on 11/01/2017.
 */
class ItemPurchaseArchiveEntryTest {

    private ItemPurchaseArchiveEntry itemPurchaseArchiveEntry;
    private Item item1;

    @BeforeEach
    void setUp() {
        item1 = new StandardItem(1,"test",50,"A",500);
        itemPurchaseArchiveEntry = new ItemPurchaseArchiveEntry(item1);
    }

    @Test
    void increaseCountHowManyTimesHasBeenSold() {
        itemPurchaseArchiveEntry.increaseCountHowManyTimesHasBeenSold(42);
        assertEquals(43,itemPurchaseArchiveEntry.getCountHowManyTimesHasBeenSold());
    }


    @Test
    void toStringTest() {

        assertEquals("ITEM  Item   ID 1   NAME test   CATEGORY A   PRICE 50.0   LOYALTY POINTS 500   HAS BEEN SOLD 1 TIMES", itemPurchaseArchiveEntry.toString());

    }

}