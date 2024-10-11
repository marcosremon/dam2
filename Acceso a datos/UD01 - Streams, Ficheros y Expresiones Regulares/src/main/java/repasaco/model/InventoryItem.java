
package repasaco.model;

public class InventoryItem {
    private String itemName;
    private String category;
    private int quantity;
    private float marketValue;

    public InventoryItem(String itemName, String category, int quantity, float marketValue) {
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.marketValue = marketValue;
    }

    public void addItem(int amount) {
        this.quantity += amount;
    }

    public void removeItem(int amount) {
        if (this.quantity >= amount) {
            this.quantity -= amount;
        }
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getMarketValue() {
        return marketValue;
    }

    @Override
    public String toString() {
        return "InventoryItem [itemName=" + itemName + ", category=" + category + ", quantity=" + quantity + ", marketValue=" + marketValue + "]";
    }
}
