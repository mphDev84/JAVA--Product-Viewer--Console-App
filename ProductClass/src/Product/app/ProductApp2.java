package Product.app;
import Product.business.*;
import Product.app.*;
import Product.database.*;

import java.util.Scanner;
public class ProductApp2 {

	
		public static void main(String args[]) {
			
			System.out.println("Welcome to the Product Viewer!");
			System.out.println();
			
			//display one or more products
			Scanner sc = new Scanner(System.in);
			String choice = "y";
			double total = 0;
			while (choice.equalsIgnoreCase("y")) {
				//get user input
				System.out.println("Enter product code: ");
				String productCode = sc.nextLine();
				
				//Using a ProductReader object to get the Product object
				ProductReader reader = new ProductDB2();
				Product product = reader.get(productCode);
				
				//display output
				String message = "\nPRODUCT"+
				"Code:			"+ product.getCode()+"\n" +
				"Description: 	"+ product.getDescription()	+"\n"+
				"Price			"+ product.getPriceFormatted()+"\n";
				System.out.println(message);
				
				total += product.getPrice();
				
				//see if the user wants to continue
				System.out.println("Do you wish to continue? (y/n)");
				choice = sc.nextLine();
				System.out.println();
			}
			
			System.out.println("Thanks and bye!");
			System.out.println("Your total is: "+total);
			sc.close();
		}
}
