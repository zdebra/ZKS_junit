package cvut.fel.zks.brabezd1.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardItemTest {

    @Test
    void copy() {

        StandardItem standardItem = new StandardItem(1,"test",50,"testcat",500);

        StandardItem copy = standardItem.copy();

        assertEquals(standardItem, copy);
        assertNotSame(standardItem, copy);

    }

    @Test
    void equals() {

        StandardItem standardItem = new StandardItem(1,"test",50,"testcat",500);
        StandardItem standardItem2 = new StandardItem(1,"test",50,"testcat",98978);

        assertTrue(standardItem.equals(standardItem));
        assertFalse(standardItem.equals(standardItem2));

    }

}