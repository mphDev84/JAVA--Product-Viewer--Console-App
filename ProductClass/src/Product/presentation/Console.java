package Product.presentation;
import java.util.Scanner;
public class Console {

	private static Scanner sc = new Scanner(System.in);//static here, since this belongs to class, not object
	
	/*the following 5 methods are static since they all belong to the class and not any object*/
	
	public static String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.next();
		sc.nextLine();//discard any other data entered on the line
		return s;
	}
	
	
	public static int getInt(String prompt) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if(sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			}else {
				System.out.println("Error! Invalid integer, please try again.");
			}
			sc.nextLine();//discard any other data entered on line
		}
		return i;
	}
	
	public static int getInt(String prompt, int min, int max) {  //getInt is overloaded here
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			i = getInt(prompt);
			if (i<=min) {
				System.out.println("Error! Integer must be greater than "+min+".");
			}else if(i>=1000) {
				System.out.println("Error! Integer must be less than "+max+".");
			}
			else {
				isValid = true;
			}
		}
		return i;
	}
	
	public static double getDouble(String prompt) {
		double d =0;
		boolean isValid = false;
		while (!isValid) {
			System.out.println(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			}else {
				System.out.println("Error! Invalid number, please try again");
			}
			sc.nextLine();
		}
		return d;
	}
	
	public static double getDouble(String prompt, double min, double max) {
		
		double d = 0;
		boolean isValid = false;
		while(!isValid) {
			d = getDouble(prompt);
			if(d<=min) {
				System.out.println("Error! Number must be greater than "+min+".");
			}else if (d>=max) {
				System.out.println("Error! Integer must be less than "+max+".");
			}else {
				isValid = true;
			}
			
		}
		return d;
	}
	
}
