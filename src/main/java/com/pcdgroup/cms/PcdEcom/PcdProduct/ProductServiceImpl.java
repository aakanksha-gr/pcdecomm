package com.pcdgroup.cms.PcdEcom.PcdProduct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<?> getAllPcdProducts(int startIndex) {
		
		List<Productmaster> getAllProducts; 
		try {
		
			getAllProducts = new ArrayList<>();
			
			if(null != String.valueOf(startIndex)) {
				
				getAllProducts = productRepository.getAllPcdProducts(startIndex);
				
				if(null != getAllProducts && getAllProducts.size() > 0) {
					
					return getAllProducts;
				
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
	public List<?> getPcdProductById(Integer productid) {
		
		List<Productmaster> pcdproduct;
		
		try {
			
			pcdproduct = new ArrayList<>();
			
			if(null != String.valueOf(productid)) {
				
				pcdproduct = productRepository.getPcdProductById(productid);
				
				if(pcdproduct != null && pcdproduct.size() > 0) {
					
					return pcdproduct;
					
				} else {
					
					System.out.println("No more records are avilable related to provided id..!");
					
				}
				
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
	@Override
	public String addNewProduct(Productmaster productmaster) {
		
		try {
			
			if(null != productRepository.getDuplicateName(productmaster.getPname())) {
				
				return "Product name is already exist..!";
				
			} else {
				
				if(null != productRepository.getMaxId()) {
					
					productmaster.setPid(productRepository.getMaxId()+1);
					
				} else {
					
					productmaster.setPid(1);
					
				}
				
				productRepository.save(productmaster);
				return "Record Added";	
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String updateProductById(Productmaster productmaster, Integer id) {
		
		try {
		
			if(null != id) {
				
				if(null != productRepository.getDuplicateName(productmaster.getPname(), id)) {
					
					return "Product name is already used by other product id..!";
					
				} else {
					
					productmaster.setPid(id);
					productRepository.save(productmaster);
					
					return "Product updated";	
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	public String deleteProduct(Integer productid) {
			
		try {
	
			Integer pid = productRepository.getProductid(productid);
				
			if(null != pid) {
				
				productRepository.deleteById(productid);
				
				return "Product Removed..!";
				
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
	public List<?> getAllOutofstockproductslist(Integer index) {
		
		try {
			
			if(null != productRepository.getAllOutofstockProducts(index) && productRepository.getAllOutofstockProducts(index).size() > 0 ) {
				
				return productRepository.getAllOutofstockProducts(index);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

}
