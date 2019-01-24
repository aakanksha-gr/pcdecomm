package com.pcdgroup.cms.PcdEcom.Vendor;

import java.util.List;

public interface VendorService {

	public String createVendor(Vendormaster vendormaster);
	public Vendormaster getVendor(Integer vendorid);
	public List<Vendormaster> getAllVendors();
	public String deleteVendor(Integer vendorid);
	public String updateVendor(Vendormaster vendormaster, Integer vendorid);
	
}
