package ca.ubc.cs.cpsc210.servicecard.tests;

import ca.ubc.cs.cpsc210.servicecard.model.FoodServicesCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for FoodServiceCard class
class FoodServicesCardTest {
    int initialBalance = 20000;
    FoodServicesCard cardA;


    @BeforeEach
    void runBefore() {
        cardA = new FoodServicesCard(initialBalance);
    }

    @Test
    public void testConstructor() {
        assertEquals(initialBalance, cardA.getBalance());
        assertEquals(0, cardA.getRewardPoints());
    }

    @Test
    public void testReloadSingle() {
        int reloadAmount = 30000;
        cardA.reload(reloadAmount);
        assertEquals(initialBalance + reloadAmount, cardA.getBalance());
    }

    @Test
    public void testReloadMultiple() {
        int reloadAmount = 30000;
        int numberOfReloads = 3;

        for (int i = 0; i < numberOfReloads; i++) {
            cardA.reload(reloadAmount);
        }
        assertEquals(initialBalance + reloadAmount * numberOfReloads,
                cardA.getBalance());
    }

    @Test
    public void testPurchasePossible() {
        int purchaseAmount = 35000;
        assertFalse(cardA.makePurchase(purchaseAmount));
    }

    @Test
    public void testNoCashback() {
        int purchaseAmount = 1800;
        assertEquals(initialBalance, cardA.getBalance());
        assertTrue(cardA.makePurchase(purchaseAmount));
        assertEquals(1800, cardA.getRewardPoints());
    }

    @Test
    public void testCashbackSinglePurchase() {
        int purchaseAmount = 3000;
        assertTrue(cardA.makePurchase(purchaseAmount));
        assertEquals(initialBalance - purchaseAmount + 10, cardA.getBalance());
        assertEquals(1000, cardA.getRewardPoints());


    }

    @Test
    public void testCashbackMultiplePurchase() {
        int purchaseAmount = 4000;
        assertTrue(cardA.makePurchase(purchaseAmount));
        assertEquals(0, cardA.getRewardPoints());
        assertEquals(initialBalance - purchaseAmount + 20, cardA.getBalance());

    }
}