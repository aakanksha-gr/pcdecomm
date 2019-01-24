package com.pcdgroup.cms.PcdEcom.ProductInventory;

import java.util.List;

public interface PcdproductinventoryService {

	public String createProductInventory(Pcdproductinventorymaster productinventorymaster);
	public Pcdproductinventorymaster getProductInventory(Integer productinventoryid);
	public List<Pcdproductinventorymaster> getAllProductInventories();
	public String deleteProductInventory(Integer ProductInventoryid);
	public String updateProductInventory(Pcdproductinventorymaster productinventorymaster, Integer productinventoryid);
	
}
