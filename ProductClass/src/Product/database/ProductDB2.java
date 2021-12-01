package Product.database;

import Product.business.Product;
import Product.business.ProductReader;

public class ProductDB2 implements ProductReader{

	public ProductDB2() {}
	
	@Override
	public Product get(String productCode) {
		Product product = new Product();
		product.setCode(productCode);
		if( productCode.equalsIgnoreCase("java")) {
			product.productSet(productCode, "Murach's Java Programming", 57.70);
		}else if (productCode.equalsIgnoreCase("jsp")) {
			product.productSet(productCode, "Murach's Java Servlets and JSP", 57.70);
		}else if (productCode.equalsIgnoreCase("mysql")) {
			product.productSet(productCode, "Murach's MySQL", 54.70);
		}else {
			product.setDescription("unknown");
		}
		return product;
		
	}
	@Override
	public String getAll() {
		throw new UnsupportedOperationException(
			"This method hasn't been implemented yet.");
		}
	}

