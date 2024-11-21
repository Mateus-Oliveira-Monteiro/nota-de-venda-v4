package model;

public class InventoryItem {
    private String code;
    private String description;
    private int quantity;

    public InventoryItem(String code, String description, int quantity) {
        this.code = code;
        this.description = description;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Code: " + code + ", Description: " + description + ", Quantity: " + quantity;
    }
}
