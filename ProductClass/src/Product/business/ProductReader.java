package Product.business;

public interface ProductReader {
	
	Product get(String code);
	String getAll();
}
