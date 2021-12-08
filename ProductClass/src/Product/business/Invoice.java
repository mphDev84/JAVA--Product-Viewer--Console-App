package Product.business;
import java.text.NumberFormat;
import java.util.List;
import java.util.ArrayList;

public class Invoice {
	
	/*refer to Murach's page 397*/
	
	//instance variable:
	private List<LineItem> lineItems;
	
	//constructor:
	public Invoice() {
		lineItems = new ArrayList<>();
	}
	
	//Next, a method that adds a LineItem to the list of lineItems
	public void addItem(LineItem lineItem) {
		lineItems.add(lineItem);
	}
	//the get accessor for the line item collection:
	public List<LineItem> getLineItems(){
		return lineItems;
	}
	
	//a method that gets the invoice total:
	public double getTotal() {
		double invoiceTotal = 0;
		for (LineItem lineItem : lineItems) {
			invoiceTotal +=lineItem.getTotal();
		}
		return invoiceTotal;
	}
	
	//method that returns the Line Item total in currency format:
	
	public String getTotalFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(getTotal());
		}

}
