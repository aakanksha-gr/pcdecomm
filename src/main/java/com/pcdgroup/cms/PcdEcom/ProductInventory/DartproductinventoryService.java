package com.pcdgroup.cms.PcdEcom.ProductInventory;

import java.util.List;

public interface DartproductinventoryService {

	public String createDartproductInventory(Dartproductinventorymaster dartproductinventorymaster);
	public Dartproductinventorymaster getDartproductInventory(Integer dartproductinventoryid);
	public List<Dartproductinventorymaster> getAllDartproductInventories();
	public String deleteDartproductInventory(Integer dartproductinventoryid);
	public String updateDartproductInventory(Dartproductinventorymaster dartproductinventorymaster, Integer dartproductinventoryid);
	
}
