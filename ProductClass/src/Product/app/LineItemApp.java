package Product.app;
import java.util.Scanner;

import Product.business.LineItem;
import Product.business.Product;
import Product.database.ProductDB;
import Product.presentation.Console;
public class LineItemApp {

	public static void main(String[] args) {
		
		/*this class refers to Murach's page 249*/
		
		System.out.println("Welcome to the Line Item Calculator!");
		System.out.println();
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			//get user input
			String productCode = Console.getString("Enter Product Code: ");
			int quantity = Console.getInt("Enter quantity:		", 0, 1000);
			
			//get the 'Product' object from 'Product.java'
			Product product = ProductDB.getProduct(productCode);
			
			//create new 'LineItem' object from 'LineItem.java'
			LineItem lineItem = new LineItem(product, quantity);
			
			//display the output to console
			
			/*Book book = new Book();
			book.productSet("oi", "dsa", 100.90);
			
			System.out.println("TEST = "+book.toString()+"\n");*/
			
			System.out.println();
			System.out.println("LINE ITEM");
			System.out.println("Code:				"+product.getCode());
			System.out.println("Description:			"+product.getDescription());
			System.out.println("Price:				"+product.getPriceNumberFormat());//new formatting - page 255
			System.out.println("Quantity:			"+lineItem.getQuantity());
			System.out.println("Total:				"+lineItem.getBigTotalFormatted()+"\n");// page 255
			
			//check if user wishes to continue
			
			choice = Console.getString("Would you like to continue? (y/n)?");
			System.out.println();
			
			
		}
		System.out.println("Thanks for using the app!");

	}

}
