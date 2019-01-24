package com.pcdgroup.cms.PcdEcom.PcdProduct;

import java.util.List;

public interface ProductService {
	
	public List<?> getAllPcdProducts(int startIndex);
	public String addNewProduct(Productmaster productmaster);
	public List<?> getPcdProductById(Integer productid);
	public String updateProductById(Productmaster productmaster, Integer id);
	public String deleteProduct(Integer productid);
	public List<?> getAllOutofstockproductslist(Integer index);
	
}
