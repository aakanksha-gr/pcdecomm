package com.pcdgroup.cms.PcdEcom.Addtocart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddtocartController {

	@Autowired
	AddtocartServiceImpl addtocartServiceImpl;
	
	@RequestMapping(method=RequestMethod.GET, value="/getAddCartItems/{id}")
	public List<?> getCartItems(@PathVariable Integer id) {
		return addtocartServiceImpl.getCartItems(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getCartItemById/{id}")
	public List<?> getCartItemsById(@PathVariable Integer id) {
		return addtocartServiceImpl.GetCartById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addCart/{id}") 
	public String addCart(@RequestBody Addtocartmaster addtocartmaster, @PathVariable Integer id) {
	 	return addtocartServiceImpl.addCart(addtocartmaster, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteCartItem/{id}/{itemid}")
	public String deleteCartItem(@PathVariable Integer id, @PathVariable Integer itemid) {
		return addtocartServiceImpl.deleteCartItem(id, itemid);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addMultiCartValue/{id}") 
	public void addMultiCartValue( @PathVariable Integer id) {
	 	addtocartServiceImpl.getMultiVal(id);
	}
	
}
