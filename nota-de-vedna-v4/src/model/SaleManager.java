package model;

public class SaleManager {
    private Inventory inventory;
    private Sale sale;

    public SaleManager() {
        this.inventory = new Inventory();
        this.sale = new Sale();
    }

    public boolean processSale(String paymentMethodCode, String productCode, int quantity) {
        sale.setPaymentMethod(paymentMethodCode);

        if (inventory.checkStock(productCode, quantity)) {
            if (sale.createSaleItem(productCode, quantity)) {
                inventory.decreaseStock(productCode, quantity);
                return true;
            }
        }

        System.out.println("Cannot process sale. Insufficient stock.");
        return false;
    }

    public double getSaleTotal() {
        return sale.getTotal();
    }

    public double getSaleFinalPrice() {
        return sale.getFinalPrice();
    }

    public void displaySaleItems() {
        for (String item : sale.getItems()) {
            System.out.println(item);
        }
    }

    public void displayStockReport() {
        System.out.println(inventory.getStockReport());
    }
}
