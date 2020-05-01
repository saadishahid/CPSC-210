package ca.ubc.cpsc210.grocery.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the GroceryBill class
class GroceryBillTest {
    GroceryBill billA;

    GroceryItem itemA;
    GroceryItem itemB;
    GroceryItem itemC;

    @BeforeEach
    void runBefore() {
        billA = new GroceryBill();

        itemA = new GroceryItem("Milk", 299);
        itemB = new GroceryItem("Cereal", 359);
        itemC = new GroceryItem("Tea", 875);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, billA.billComplete.size());
    }

    @Test
    public void testAddOnePurchase() {
        billA.addPurchase(itemA, 1);
        assertEquals(1, billA.getNumLineItems());
        assertEquals(1, billA.getTotalQuantityOfItemPurchased(itemA));
        assertEquals(1, billA.getTotalNumberOfItemsPurchased());
    }

    @Test
    public void testAddMultiplePurchase() {
        billA.addPurchase(itemA, 1);
        billA.addPurchase(itemB, 2);
        billA.addPurchase(itemA, 3);
        assertEquals(2, billA.getNumLineItems());
        assertEquals(2, billA.getTotalQuantityOfItemPurchased(itemB));
        assertEquals(4, billA.getTotalQuantityOfItemPurchased(itemA));
        assertEquals(6, billA.getTotalNumberOfItemsPurchased());
    }

    @Test
    public void testTotalNumberOfItemsPurchased() {
        billA.addPurchase(itemC, 2);
        billA.addPurchase(itemA, 1);
        assertEquals(3, billA.getTotalNumberOfItemsPurchased());
    }

    @Test
    public void testGetNumLineItems() {
        billA.addPurchase(itemC, 2);
        billA.addPurchase(itemA, 1);
        assertEquals(2, billA.getNumLineItems());

    }

    @Test
    public void testTotalQuantityOfItemPurchased() {
        billA.addPurchase(itemA, 1);
        assertEquals(1, billA.getTotalQuantityOfItemPurchased(itemA));

    }

    @Test
    public void testToString() {
        billA.addPurchase(itemC, 2);
        assertEquals("2x Tea @ $8.75\n", billA.toString());
        billA.addPurchase(itemB, 3);
        assertEquals("2x Tea @ $8.75\n3x Cereal @ $3.59\n", billA.toString());
    }
}