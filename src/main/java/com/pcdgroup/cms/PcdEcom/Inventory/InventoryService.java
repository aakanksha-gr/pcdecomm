package com.pcdgroup.cms.PcdEcom.Inventory;

import java.util.List;

public interface InventoryService {

	public String createInventory(Inventorymaster inventorymaster);
	public Inventorymaster getInventory(Integer inventoryid);
	public List<Inventorymaster> getAllInventory();
	public String deleteInventory(Integer inventoryid);
	public String updateInventory(Inventorymaster inventorymaster, Integer inventoryid);
	public List<Inventorymaster> getAllOutofstockInventory();
	public List<Inventorymaster> getAllInventoryByBrand(String brand);
	
}
