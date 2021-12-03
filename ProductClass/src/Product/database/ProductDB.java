package Product.database;
import Product.business.*;
import Product.app.*;



/*the below code refers to Murach's page 235 - this is an example of a STATIC INITIALIZATION BLOCK. This is for
 * reference only and does not apply to the ProductApp exercise in Murach's*/

import java.sql.Connection;
import java.sql.DriverManager;

public class ProductDB {

	private static Connection connection;
	
	static {
		try {
			String url = "jdbc:mysql://localhost3306/MurachDB";
			String user = "root";
			String password = "sesame";
			connection = DriverManager.getConnection(url, user, password);
		}
		catch (Exception e) {
			System.err.println("Error connecting to database");
		}
	}
	
	//code below creates an object 'product' from the product class; the .productSet() method is called once the user specifies 
	//the product code, and the relevent data is passed to the object.
	
	public static Product getProduct(String productCode) {
	
		Product product = null;
		
		if (productCode.equalsIgnoreCase("java")|| productCode.equalsIgnoreCase("jsp")
		|| productCode.equalsIgnoreCase("mysql")|| productCode.equalsIgnoreCase("coding")){
		
			Book b = new Book();
			
		if (productCode.equalsIgnoreCase("java")) {
			b.productSet("java-code", "Murach's java book", 57.50);//calls 'productSet' method to fill out data for the Product
			b.setAuthor("Joel Murach");
		} else if(productCode.equalsIgnoreCase("jsp")) {
			b.productSet("jsp-code", "Murach's java servlets and JSP", 57.50);
			b.setAuthor("Mike Urban");
		}else if (productCode.equalsIgnoreCase("mysql")) {
			b.productSet("mysql-code", "Murach's mySQL", 54.50);
			b.setAuthor("Silly McSilly Face");
		}else if (productCode.equalsIgnoreCase("coding")) {
			b.productSet("coding-code", "Matt's coding boot-camp", 56.50);
			b.setAuthor("Matt F Howels");
		}
		product=b; //remember we set 'product' to "Null" above 
		
		}else if(productCode.equalsIgnoreCase("eclipse")){
			Software s = new Software();
			s.productSet("Eclipse", "Eclipse", 0);
			s.setVersion("17.5");
			
			product = s;
			
		}else if(productCode.equalsIgnoreCase("sgtp")) {
			Album a = new Album();
			a.productSet("The Beatles", "Sgt. Peppers", 20.00);
			a.setArtist("The Beatles");
			
			product = a;
			
		}else if(productCode.equalsIgnoreCase("sgtp")||productCode.equalsIgnoreCase("abbey")) {
			Album a = new Album();
			if (productCode.equalsIgnoreCase("sgtp")) {
			a.productSet("The Beatles", "Sgt. Peppers", 20.00);
			a.setArtist("The Beatles");
			}else if (productCode.equalsIgnoreCase("abbey")) {
				a.productSet("The Beatles", "Abbey Road", 20.00);
				a.setArtist("The Beatles");
			}
			product = a;
		}else {
			Product p1 = new Product();
			p1.productSet("unknown", "unknown", 0);
			product = p1;
		}
		return product;
	}
	
}
