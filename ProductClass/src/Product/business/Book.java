package Product.business;

public class Book extends Product implements Printable {

	/*Page 267 of Murach's*/
	
	private String author;
	
	public Book() {
		super();//calls constructor of Product superclass
		author ="";
		count++;
	}
	
	public void setAuthor(String author) {
		this.author=author;
	}
	public String getAuthor() {
		return author;
	}
	/*@Override //this overrides the toString method found in 'Product.java'
	
	public String toString() {
		return super.toString()+" by "+author;//calls method from superclass 'Product'
	}*/
	
	/*note the above @Override method for '.toString()'. We can now implement Printable to do the following:*/
	
	@Override
	public void print() {
		System.out.println(super.getDescription()+" by the author "+author);
	}
	
}
