package Product.app;
import Product.business.*;
import Product.app.*;
import Product.database.*;

import java.util.Scanner;
public class ProductApp {

	public static void main(String[] args) {
		/*this program refers to Murach's page 239, and is the class that contains the 'user interface' that
		 * is displayed at console. This class utilizes the Product and ProductDB classes */
		
		System.out.println("Welcome to the product viewer");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		double x;
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter product code: ");//user input
			String productCode = sc.nextLine();
			
			
			
			//gets the 'product' object using above user input
			Product product = ProductDB.getProduct(productCode);
			
			//the commented out code below interferes with the 'product != null' call 
			
			//double price = product.getPrice();
			//System.out.println(price);
			
			/*messy code below refers to Murach's page 241*/
			
			/*System.out.println(price+" is increased to "+product.increasePrice(price));
			System.out.println();*/ //this is using the variable price as a parameter
	
			//Product.increasePriceTwo(product); //this is using the object as a parameter
			//System.out.println("Price increase: "+product.getPriceFormatted());
			/*
			product.setPrice(product.increasePrice(price));
			System.out.println(product.getPrice());
			*/
			//now we display the output
			
			//product.printToConsole(" ");
			//product.printToConsole();   
			
			/*the above code refers to Murach's page 243 on method overloading. When overloading methods
			 * we code 2 or more methods with the same name, but each has different parameters (or each method
			 * has a unique signature). These parameters must have a different data type from the other methods */
			
			System.out.println();
			System.out.println("SELECTED PRODUCT:");
			if (product !=null) {
				System.out.println("Description:	"+product.toString());
				System.out.println("Price:			"+product.getPriceFormatted());
			} else {
				System.out.println("No product matches this product code.");
			}
			
			System.out.println();
			System.out.println("Product count: "+Product.getCount()+"\n");
			
			//statement to see if user wishes to continue
			
			System.out.println("Do you wish to continue? (y/n): ");
			choice = sc.nextLine();
			System.out.println();
		}
		
		System.out.println("Thanks for using the App!");
	}

}
