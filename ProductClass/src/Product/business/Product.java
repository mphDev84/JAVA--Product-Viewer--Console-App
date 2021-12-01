package Product.business;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
public class Product implements Printable, Cloneable { //implements 'Printable' interface and 'Cloneable' interface

/*this class refers to page 217 in Murach's*/
	
	//instance variables:
	
	private String code;
	private String description;
	private double price;
	private String price2;
	protected static int count = 0;

	//constructor which creates and instance (or object) of the 'Product' class - page 221 shows other ways of
	//doing this
	
	public Product() {}
	//this constructor completes page 255(5-7) constructor exercise:
public Product(String code) {}
	
	public void productSet(String a, String b, double c) {
		setCode(a);
		setDescription(b);
		setPrice(c);
	}
	
	//the following blocks of code are 'set' and 'get' methods
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	
	public static double increasePrice(double price) {
		
		price = price*1.1;
		return price;
	}
	public static void increasePriceTwo(Product product) {
		double price = product.getPrice() *1.1;
		product.setPrice(price);
	}
	
	//OVERLOADING METHODS
	
	public void printToConsole(String sep) { //refers to Murach's page 243
		System.out.println(code + sep+description+sep+price);
	}
	public void printToConsole() {
		printToConsole("|");
	}
	
	/*the above code refers to Murach's page 243 on method overloading. When overloading methods
	 * we code 2 or more methods with the same name, but each has different parameters (or each method
	 * has a unique signature). These parameters must have a different data type from the other methods */
	
	
	//following code converts double 'price' to a string so that the currency is displayed
	
	public String getPriceFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(price);
	}
	
	//the following code sets 
	public BigDecimal getPriceNumberFormat() {

		BigDecimal bigPrice = new BigDecimal(price);
		return bigPrice.setScale(2, RoundingMode.HALF_UP);
	}
	public static int getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return description;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Product) {
			Product p2 = (Product) object; //casting 'Object' object back to 'Product'
			if (code.equals(p2.getCode())&& description.equals(p2.getDescription())&&price == p2.getPrice()) {
				return true;
			}
			}
		return false;
		}
	
	/*here the method 'print()' is declared from the Printable interface-- see 'ProuctCLassTestArea' for the
	 * method call and output */
	
	public void print() {
		System.out.print(description);
	}
	public static void printMultiple(Printable p, int count) {
		for(int i=0; i<count;i++) {
			p.print();
		}
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	}

	


