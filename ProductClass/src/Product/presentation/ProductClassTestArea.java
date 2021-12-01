package Product.presentation;
import Product.business.Book;
import Product.business.Employee;
import Product.business.Printable;
import Product.business.Product;
import Product.business.ProductReader;
import Product.database.ProductDB;
import Product.database.ProductDB2;


public class ProductClassTestArea {

	public static void main(String[] args) {

		/*this code refers to Murach's page 279 on inheritance and object casting. Also read on to page 281
		 * for object comparison */
		
		Book b = new Book();
		
		Product p = b;
		
		p.productSet("Matthew", "howels", 40.66);
		System.out.println(p.getPrice());
		
		/*p.setAuthor("matt");*/ //this won't work since 'Product.java' does not contain the method '.setAuthor'. 
		//Book.class has this method
		
		b.setPrice(66.77);
		b.setAuthor("M Howels");
	
		System.out.println("Book by "+b.getAuthor()+" costs "+b.getPrice()+". The code is: "+b.getCode());
		
		Product p1 = new Book();

		if (p1 instanceof Book) {
			System.out.println("This is a Book object");
		}
		/*
		p1.setAuthor("no one");
		System.out.println(p1.getAuthor());*/ // doesn't work!!
		
		Book b2 = (Book) p; //cast Product object back to Book 
		b2.setAuthor("author"); // this works!
		
		
		Product p2 = new Product();
		Product p3 = new Product();
		/*
		if (p2.equals(p3)) {
			System.out.println("true!");
		}else {
			System.out.println("false!");
		}
		*/
		
		//the below code uses a new method (See 'Product.java' - new method overrides the .equals() method)
		
		p2.productSet("java1", "java2", 46.66);
		
		Product p4 = new Product();
		
		//the below code refers to Murach's page 317
		
		try {
		p4.productSet("java1", "java2", 46.66);
		Product p5 = (Product) p4.clone();//p5 is a clone of p4
		p5.setPrice(56.66);
		System.out.println(p2.equals(p4)); //check the price - this will return false!!
		System.out.println(p5.getPrice());//outputs the newly updated price
		}catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
		
		/*A NOTE ABOUT ABSTRACT CLASSES (PAGE 283)
		 * - is coded with the 'abstract' keyword in the class declaration, ie. public abstract class Product {}
		 * - cannot be used to create an object
		 * - a child class CAN inherit the abstract class, and from the child class, an object can be created
		 * - if a child class uses the parent abstract class's methods, these methods MUST be overwritten
		 * 
		 * A NOTE ABOUT THE 'FINAL' KEYWORD
		 * - when declaring classes, parameters or methods as final, we make sure that no one can override
		 * or change said classes, methods and parameters
		 * - A class declared 'final' cannot be inherited, a sub-class cannot be created  */
		
		Printable prt = ProductDB.getProduct("sgtp");
		prt.print();
		
		Employee matt = new Employee (1, "howels", "matthew");
		matt.print();
		Book newBook = new Book();
		newBook.productSet("john", "lennon", 33.99);
		System.out.println();
		newBook.setAuthor("matt howels");
		newBook.print();
		System.out.println();
		newBook.printMultiple(matt, 2);
	
}
}