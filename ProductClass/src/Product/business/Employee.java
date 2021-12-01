package Product.business;
/*this is a class that implements TWO interfaces*/

public class Employee implements Printable, DepartmentConstants {

	private int department;
	private String firstName;
	private String lastName;
	
	public Employee (int department, String lastName, String firstName) {
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public void print() {//calling and overriding the print method from 'Printable' interface
		String dept = "Unknown";
		if (department==ADMIN) {//static constants can be used without qualifying they are from DepartmentConstants.java
			dept = "Administration";
		}else if(department == EDITORIAL){
			dept = "Editorial";
		}else if(department == MARKETING) {
			dept = "Marketing";
		}
		
		System.out.println();
		System.out.print(firstName+" "+lastName+ " ("+dept+")");
	}
	
}
