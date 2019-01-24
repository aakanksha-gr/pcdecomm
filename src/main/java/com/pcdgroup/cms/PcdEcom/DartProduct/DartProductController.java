package com.pcdgroup.cms.PcdEcom.DartProduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DartProductController {

	@Autowired
	DartProductServiceImpl dartProductServiceImpl;
	
	@RequestMapping(method=RequestMethod.GET, value="/viewAllDartProduct/{startIndx}")
	public List<?> findAllDertProduct(@PathVariable int startIndx) {
		
		return dartProductServiceImpl.getAllDartProduct(startIndx);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewDartProductById/{dartProductId}")
	public List<?> findDartProductById(@PathVariable Integer dartProductId) {
		
		return dartProductServiceImpl.getDartProductById(dartProductId);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addDartProduct")
	public String addNewProduct(@RequestBody Dartproductmaster dartproductmaster) {
		return dartProductServiceImpl.addNewProduct(dartproductmaster);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateDartProduct/{productid}")
	public String updateProductById(@RequestBody Dartproductmaster productmaster, @PathVariable Integer productid) {
		
		return dartProductServiceImpl.updateProductById(productmaster, productid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteDartProductByProductId/{productid}")
	public String deleteDartProduct(@PathVariable Integer productid) {
		return dartProductServiceImpl.deleteProduct(productid);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewAllOutofstockDartProduct/{startIndx}")
	public List<?> findAllOutofstockDertProduct(@PathVariable int startIndx) {
		
		return dartProductServiceImpl.getAllOutofstockProducts(startIndx);
	
	}
	
}
