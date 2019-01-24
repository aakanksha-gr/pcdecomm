package com.pcdgroup.cms.PcdEcom.Vendorinventory;

import java.util.List;

public interface VendorinventoryService {

	public String createVendorinventory(Vendorinventorymaster vendorinventorymaster);
	public Vendorinventorymaster getVendorinventory(Integer vendorinventoryid);
	public List<Vendorinventorymaster> getAllVendorinventory();
	public String deleteVendorinventory(Integer vendorinventoryid);
	public String updateVendorinventory(Vendorinventorymaster vendorinventorymaster, Integer vendorinventoryid);
	
}
