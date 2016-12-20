package cvut.fel.zks.brabezd1.storage;

import cvut.fel.zks.brabezd1.shop.Item;


/**
 * Auxiliary class for item storage
 */
public class ItemStock {
    private Item refItem;
    private int count;
    
    ItemStock(Item refItem) {
        this.refItem = refItem;
        count = 0;
    }

    @Override
    public String toString() {
        return "STOCK OF ITEM:  "+refItem.toString()+"    PIECES IN STORAGE: "+count;
    }
    
    void increaseItemCount(int x) {
        count += x;
    }
    
    void decreaseItemCount(int x) {
        count -= x;
        count = count < 0 ? 0 : count;
    }
    
    int getCount() {
        return count;
    }
    
    Item getItem() {
        return refItem;
    }
}