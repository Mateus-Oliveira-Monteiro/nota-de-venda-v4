package view;

import model.SaleManager;

public class Main {
	public static void main(String[] args) {
		SaleManager saleManager = new SaleManager();

		if (saleManager.processSale("c", "at", 2)) {
			System.out.println("Item 'Arroz Tatiana' adicionado à venda!");
		}

		if (saleManager.processSale("c", "ff", 1)) {
			System.out.println("Item 'Feijão Fejó' adicionado à venda!");
		}

		if (saleManager.processSale("c", "msa", 2)) {
			System.out.println("Item 'Macarrão Santa Amália' adicionado à venda!");
		}

		System.out.println("\nItens da venda:");
		saleManager.displaySaleItems();

		System.out.println(String.format("\nTotal: %.2f", saleManager.getSaleTotal()));

		System.out.println(String.format("Forma de pagamento: '%s'", saleManager.getSaleFinalPrice()));

		System.out.println(String.format("Valor a ser pago: R$%.2f", saleManager.getSaleFinalPrice()));


		System.out.println("\nRelatório de estoque após a venda:");
		saleManager.displayStockReport();
	}
}
