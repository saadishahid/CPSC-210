package ca.ubc.cpsc210.grocery.model;

import java.util.ArrayList;

// Represents a grocery bill having a list of line items
public class GroceryBill {
    ArrayList<LineItem> billComplete; //Item (Description + Unit Price + quantity)


    // EFFECTS: constructs an empty grocery bill
    public GroceryBill() {
        billComplete = new ArrayList<LineItem>();
    }

    // MODIFIES: this
    // EFFECTS: adds a purchase to the grocery bill where item is the grocery item purchased
    // and quantity is the quantity of that item purchased; if item has previously been added
    // to this bill, quantity of item purchased is increased on previous entry, rather than
    // adding a new entry
    public void addPurchase(GroceryItem item, int quantity) {
        int i = 0;
        for (int j = 0; j < billComplete.size(); j++) {
            billComplete.get(j);
            if (item.getDescription().equals(billComplete.get(j).getGroceryItem().getDescription())) {
                billComplete.get(j).addQuantity(quantity);
                i = 1;
            }
        }
        // new item added
        if (i == 0) {
            billComplete.add(new LineItem(item, quantity));
        }

    }

    // EFFECTS: returns total number of items purchased
    public int getTotalNumberOfItemsPurchased() {
        int itemsPurchased = 0;
        for (int j = 0; j < billComplete.size(); j++) {
            itemsPurchased = itemsPurchased + billComplete.get(j).getQuantity();
        }
        return itemsPurchased;
    }

    // EFFECTS: returns number of line items on this bill
    public int getNumLineItems() {
        return billComplete.size();
    }

    // EFFECTS: returns total quantity of item purchased on this bill;
    // returns 0 if the item has not been added to bill
    public int getTotalQuantityOfItemPurchased(GroceryItem item) {
        int itemQuantity = 0;
        for (LineItem lineItem : billComplete) {
            if (item == lineItem.getGroceryItem()) {
                itemQuantity = lineItem.getQuantity();
            }
        }
        return itemQuantity;
    }

    // EFFECTS: returns a string representing this bill where each
    // line item is recorded on a line of its own in the format
    // (quantity)x (item)
    // For example:
    // 2x cheese @ $1.49
    // 4x red bull @ @2.99
    // 1x macaroni cheese @ $3.55
    public String toString() {
        String billLine = "";
        System.out.println("Grocery Bill: ");
        for (LineItem j : billComplete) {
            String price = Integer.toString(j.getGroceryItem().getPrice());
            int priceLength = price.length();
            billLine = billLine + (j.getQuantity() + "x "
                    + (j.getGroceryItem().getDescription())
                    + " @ $" + price.substring(0, priceLength - 2) + "." + price.substring(priceLength - 2) + "\n");
        }
        return billLine;

    }
}
