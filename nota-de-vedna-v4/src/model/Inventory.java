package model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, InventoryItem> inventoryItems = new HashMap<>();

    public Inventory() {
        for (String code : DataBase.products.keySet()) {
            String[] productData = DataBase.products.get(code);
            InventoryItem item = new InventoryItem(code, productData[0], Integer.parseInt(productData[1]));
            inventoryItems.put(code, item);
        }
    }

    public boolean checkStock(String code, int quantity) {
        InventoryItem item = inventoryItems.get(code);
        return item != null && item.getQuantity() >= quantity;
    }

    public void decreaseStock(String code, int quantity) {
        InventoryItem item = inventoryItems.get(code);
        if (item != null) {
            item.setQuantity(item.getQuantity() - quantity);
        }
    }

    public String getStockReport() {
        StringBuilder report = new StringBuilder("Stock Report:\n");
        for (InventoryItem item : inventoryItems.values()) {
            report.append(item.toString()).append("\n");
        }
        return report.toString();
    }
}
