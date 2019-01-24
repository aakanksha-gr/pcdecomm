package com.pcdgroup.cms.PcdEcom.Addtocart;

import java.util.List;

public interface AddtocartService {
	
	public List<?> getCartItems(Integer id);
	public String addCart(Addtocartmaster addtocartmaster, Integer id);
	public String deleteCartItem(Integer id, Integer itemid);
	public List<?> GetCartById(Integer userid);

}
