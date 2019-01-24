package com.pcdgroup.cms.PcdEcom.PcdProduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@RequestMapping(method=RequestMethod.GET, value="/viewAllProduct/{startIndex}")
	public List<?> findAllProduct(@PathVariable int startIndex) {
		
		return productServiceImpl.getAllPcdProducts(startIndex);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewPcdProductById/{pcdProductId}")
	public List<?> findPcdProductById(@PathVariable Integer pcdProductId) {
		
		return productServiceImpl.getPcdProductById(pcdProductId);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addProduct")
	public String addNewProduct(@RequestBody Productmaster productmaster) {
	
		return productServiceImpl.addNewProduct(productmaster);

	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateProduct/{productid}")
	public String updateProductById(@RequestBody Productmaster productmaster, @PathVariable Integer productid) {
		
		return productServiceImpl.updateProductById(productmaster, productid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteProductByProductId/{productid}")
	public String deleteProduct(@PathVariable Integer productid) {
		return productServiceImpl.deleteProduct(productid);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewAllOutofstockProduct/{startIndex}")
	public List<?> findAllOutofstockProduct(@PathVariable int startIndex) {
		
		return productServiceImpl.getAllOutofstockproductslist(startIndex);
	
	}
	
}
