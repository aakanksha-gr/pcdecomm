package com.pcdgroup.cms.PcdEcom.DartProduct;

import java.util.List;

public interface DartProductService {
	
	public List<Dartproductmaster> getAllDartProduct(int startindx);
	public List<?> getDartProductById(Integer productid);
	public String addNewProduct(Dartproductmaster dartproductmaster);
	public String updateProductById(Dartproductmaster productmaster, Integer productid);
	public String deleteProduct(Integer productid);
	public List<?> getAllOutofstockProducts(Integer strtindx);
	
}
