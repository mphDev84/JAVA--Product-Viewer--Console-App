package Product.app;
import Product.business.*;
import Product.database.*;
import Product.presentation.*;

public class InvoiceApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Invoice Application\n");
		Invoice invoice = new Invoice();
		getLineItems(invoice);
		displayInvoice(invoice);
	}
	
	//method to get user input - product code and quantity of items
	public static void getLineItems(Invoice invoice) {
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String productCode = Console.getString("Enter product code: ");
			int quantity = Console.getInt("Enter quantity: ");
			
			Product product = ProductDB.getProduct(productCode);
			invoice.addItem(new LineItem(product, quantity));
			
			choice = Console.getString("Another line item? (y/n)");
			System.out.println();
			
		}
	}
	
	public static void displayInvoice(Invoice invoice) {
		System.out.println("Code\t\tDescription\t\t\tPrice\tQty\tTotal");
		System.out.println("----\t\t-----------\t\t\t-----\t---\t-----");
		for (LineItem lineItem: invoice.getLineItems()) {
			Product product = lineItem.getProduct();
			String s = product.getCode()
				+ "\t"+ product.getDescription()
				+ "\t"+ product.getPriceFormatted()
				+ "\t"+ lineItem.getQuantity()
				+ "\t"+ lineItem.getTotalFormatted();
			System.out.println(s);
		}
		System.out.println("\n\t\t\t\t\tInvoice total:\t" 
				+ invoice.getTotalFormatted() + "\n");
	}
}
