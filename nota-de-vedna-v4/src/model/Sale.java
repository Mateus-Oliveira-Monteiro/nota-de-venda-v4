package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private List<SaleItem> items = new ArrayList<>();
	private PaymentMethod paymentMethod;

	// Atualização do método para retornar boolean
	public boolean createSaleItem(String code, int quantity) {
		// Verifica se o produto existe na base de dados
		String[] productData = DataBase.selectProduct(code);
		if (productData != null) {
			SaleItem item = new SaleItem();
			item.createProduct(code, quantity);
			items.add(item);
			return true;  // Item criado com sucesso
		}
		return false;  // Produto não encontrado
	}

	public double getTotal() {
		double total = 0;
		for (SaleItem saleItem : items) {
			total += saleItem.getSubtotal();
		}
		return total;
	}

	public List<String> getItems() {
		List<String> itemsStr = new ArrayList<>();
		for (SaleItem saleItem : items) {
			itemsStr.add(saleItem.toString());
		}
		return itemsStr;
	}

	public double getFinalPrice() {
		return paymentMethod.calculate(getTotal());
	}

	public void setPaymentMethod(String payment) {
		paymentMethod = DataBase.selectPayment(payment);
	}

	public String getPaymentMethod() {
		return paymentMethod.toString();
	}
}
