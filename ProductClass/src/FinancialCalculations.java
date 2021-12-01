


/* this page of code refers to Murach's page 231 and is only meant as a guide using examples of how to
 * code static constants and static methods. REMEMBER - static constants and methods belong to THE CLASS, whereas
 * instance variables and regular methods belong to THE OBJECT that is created from a class*/

public class FinancialCalculations {
	
	public static final int MONTHS_IN_YEAR = 12;
	
	public static double calculateFutureValue(double monthlyPayment, double yearlyInterestRate, int years) {
		int months = years * MONTHS_IN_YEAR;
		double monthlyInterestRate = yearlyInterestRate/MONTHS_IN_YEAR/100;
		double futureValue = 0;
		for (int i=0; i<= months; i++) {
			futureValue = (futureValue + monthlyPayment)*(1+monthlyInterestRate);
		}
		return futureValue;
	}

}


/*the 'Product' class - see Product.java - with a static variable and a static method */

/* public class Product{
	
	private String code;
	private String description;
	private double price;
	
	private static int objectCount = 0; //declare a static variable
	
	public Product() {
		code="";
		description = "";
		price = 0;
		objectCount++;  //this updates the static variable
	}
	
	public static int getObjectCount() {
		return objectCount;
	}
	
}

*/

