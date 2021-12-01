package Product.business;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class LineItem {

	private Product product;
	private int quantity;
	
	public LineItem (Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public double getTotal() {
		double total = product.getPrice()*quantity;
		return total;
		
	}
	
	public String getTotalFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(this.getTotal());
	}
	
	
	//the below code completes page 255 exercises (8 -10):
	
	public BigDecimal getBigTotalFormatted() {
	BigDecimal bigTotal = new BigDecimal(getTotal());
	return bigTotal.setScale(2, RoundingMode.HALF_UP);
}
}
