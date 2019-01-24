package com.pcdgroup.cms.PcdEcom.DartProduct;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DartProductServiceImpl implements DartProductService {

	@Autowired
	DartProductRepository productRepository;
	
	@Autowired
    EntityManager em;
	
	@Override
	public List<Dartproductmaster> getAllDartProduct(int startindx) {
		
		List<Dartproductmaster> dartproducts;
		
		try {
			
			dartproducts = new ArrayList<>();
			if(null != String.valueOf(startindx)) {
			
				dartproducts = productRepository.getAllDartProducts(startindx);
				System.out.println(dartproducts);
				if(null != dartproducts && dartproducts.size() > 0) {
					
					return dartproducts;
				
				} else {
					
					System.out.println("No more records are avilable..!");
					
				}
				
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
		
		}
		
		return null;
	
	}

	@Override
	public List<?> getDartProductById(Integer productid) {
		
		List<Dartproductmaster> dartproduct;
		
		try {
			
			dartproduct = new ArrayList<>();
			
			if(null != String.valueOf(productid)) {
				
				dartproduct = productRepository.getDartProductById(productid);
				
				if(dartproduct != null && dartproduct.size() > 0) {
					
					return dartproduct;
					
				} else {
					
					System.out.println("No more records are avilable related to provided id..!");
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public String addNewProduct(Dartproductmaster dartproductmaster) {
		
		try {
				
			if(null != productRepository.getDuplicateName(dartproductmaster.getPname().trim())) {
				
				return "Product name is already exist..!";
				
			} else {
				
				if(null != productRepository.getMaxId()) {
					
					dartproductmaster.setPid(productRepository.getMaxId()+1);
					
				} else {
					
					dartproductmaster.setPid(1);
					
				}
				
				if(Integer.valueOf(dartproductmaster.getPmimistock()) > Integer.valueOf(dartproductmaster.getStock())) {
					
					dartproductmaster.setDartproductstockstatus("out of stock");
					
				} else {
					
					dartproductmaster.setDartproductstockstatus("in stock");
					
				}
				
				productRepository.save(dartproductmaster);
				return "Record Added";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	}

	public String updateProductById(Dartproductmaster productmaster, Integer productid) {
		
		if(null != productid) {
			
			if(null != productRepository.getDuplicateName(productmaster.getPname(), productid)) {
				
				return "Product name already used by other product id..";
			
			} else {
				
				productmaster.setPid(productid);
				
				if(Integer.valueOf(productmaster.getPmimistock()) > Integer.valueOf(productmaster.getStock())) {
					
					productmaster.setDartproductstockstatus("out of stock");
					
				} else {
					
					productmaster.setDartproductstockstatus("in stock");
					
				}
				
				productRepository.save(productmaster);
				
				return "Product updated";
				
			}	
				
		}
		
		return null;
	}

	public String deleteProduct(Integer productid) {
		
		try {
			
			Integer dpid = productRepository.getDartProductid(productid);
				
			if(null != dpid) {
				
				productRepository.deleteById(productid);
				
				return "Dart-Product Removed..!";
				
			} else {
				
			return "The Product is already deleted or not avilable with provided product id..!";
				
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	
	}

	@Override
	public List<?> getAllOutofstockProducts(Integer strtindx) {
		
		try {
			
			if(null != productRepository.getAllOutofstockProducts(strtindx) && productRepository.getAllOutofstockProducts(strtindx).size() > 0) {
				
				return productRepository.getAllOutofstockProducts(strtindx);
				
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

}
