package cvut.fel.zks.brabezd1.storage;

import cvut.fel.zks.brabezd1.shop.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    Storage storage;
    Item item1, item2, item3, item4, item5;


    @BeforeEach
    void setUp() {

        storage = new Storage();
        item1 = new StandardItem(1,"test",50,"A",500);
        item2 = new StandardItem(2,"test45",50,"B",500);
        item3 = new DiscountedItem(3,"test123",100,"A",10,"12.12.2015", "24.12.2017");
        item4 = new DiscountedItem(4,"asda",100,"A",10,"12.12.2015", "24.12.2017");
        item5 = new DiscountedItem(5,"tescxzczt123",100,"B",10,"12.12.2015", "24.12.2017");

    }

    @Test
    void insertItems() {

        storage.insertItems(item1, 10);
        storage.insertItems(item1, 10);

        assertEquals(1,storage.getStockEntries().size());
        storage.insertItems(item2, 10);
        storage.insertItems(item3, 10);
        storage.insertItems(item4, 10);
        storage.insertItems(item5, 10);

        assertEquals(5,storage.getStockEntries().size());

    }

    @Test
    void removeItems() throws NoItemInStorage {

        assertThrows(NoItemInStorage.class, () -> {
            storage.removeItems(item1, 10);
        });

        storage.insertItems(item1, 3);

        assertThrows(NoItemInStorage.class, () -> {
            storage.removeItems(item1, 10);
        });

        storage.removeItems(item1, 3);

        assertEquals(0,storage.getItemCount(item1));

    }

    @Test
    void processOrder() throws NoItemInStorage {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        Order order = new Order(shoppingCart, "pepa", "address");

        assertThrows(NoItemInStorage.class, () -> {
            storage.processOrder(order);
        });

        storage.insertItems(item1, 3);

        assertThrows(NoItemInStorage.class, () -> {
            storage.processOrder(order);
        });

        storage.insertItems(item2, 1);

        storage.processOrder(order);

        assertThrows(NoItemInStorage.class, () -> {
            storage.processOrder(order);
        });

    }

    @Test
    void getItemCount() {
        storage.insertItems(item2, 10);
        storage.insertItems(item1, 12);
        storage.insertItems(item2, 13);
        storage.insertItems(item2, 14);

        assertEquals(37, storage.getItemCount(item2));
    }

    @Test
    void getPriceOfWholeStock() {

        assertEquals(0,storage.getPriceOfWholeStock());

        storage.insertItems(item1, 10);
        assertEquals(500,storage.getPriceOfWholeStock());
        storage.insertItems(item1, 10);
        assertEquals(1000,storage.getPriceOfWholeStock());
        storage.insertItems(item3, 10);
        assertEquals(1900,storage.getPriceOfWholeStock());

    }

    @Test
    void getItemsOfCategorySortedByPrice() {

        storage.insertItems(item1, 10);
        storage.insertItems(item1, 10);
        storage.insertItems(item2, 10);
        storage.insertItems(item3, 10);
        storage.insertItems(item4, 10);
        storage.insertItems(item5, 10);

        ArrayList<Item> sorted = (ArrayList<Item>) storage.getItemsOfCategorySortedByPrice("A");

        assertEquals(item1,sorted.get(0));
        assertEquals(item3,sorted.get(1));
        assertEquals(item4,sorted.get(2));

    }

}