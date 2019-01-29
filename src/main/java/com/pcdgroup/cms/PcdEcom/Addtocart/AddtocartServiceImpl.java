package com.pcdgroup.cms.PcdEcom.Addtocart;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.Bill.BillServiceImpl;
import com.pcdgroup.cms.PcdEcom.Bill.Billmaster;
import com.pcdgroup.cms.PcdEcom.DartProduct.DartProductRepository;
import com.pcdgroup.cms.PcdEcom.DartProduct.DartProductServiceImpl;
import com.pcdgroup.cms.PcdEcom.DartProduct.Dartproductmaster;
import com.pcdgroup.cms.PcdEcom.Inventory.InventoryRepository;
import com.pcdgroup.cms.PcdEcom.Inventory.InventoryServiceImpl;
import com.pcdgroup.cms.PcdEcom.Inventory.Inventorymaster;
import com.pcdgroup.cms.PcdEcom.Order.Ordermaster;
import com.pcdgroup.cms.PcdEcom.Order.OrdermasterRepository;
import com.pcdgroup.cms.PcdEcom.PcdProduct.ProductRepository;
import com.pcdgroup.cms.PcdEcom.PcdProduct.ProductServiceImpl;
import com.pcdgroup.cms.PcdEcom.PcdProduct.Productmaster;



@Service
public class AddtocartServiceImpl implements AddtocartService {

	@Autowired
	AddtocartRepository addtocartRepository;
	
	@Autowired
	OrdermasterRepository ordermasterRepository;
	
	Ordermaster ordermaster;
	
	Inventorymaster inventorymaster;
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	InventoryServiceImpl inventoryServiceImpl;
	
	Dartproductmaster dartproductmaster;
	
	@Autowired
	DartProductRepository dartProductRepository;
	
	@Autowired
	DartProductServiceImpl dartProductServiceImpl ;
	
	Productmaster productmaster;
	
	@Autowired
	ProductServiceImpl productServiceImpl; 
	
	@Autowired
	ProductRepository productRepository;
	
	Billmaster billmaster;
	
	@Autowired
	BillServiceImpl billServiceImpl;
	
	@Override
	public List<?> getCartItems(Integer id) {
		
		List<?> cartList;
		
		try {
			
			cartList = new ArrayList<>();
			
			cartList = addtocartRepository.getAllOrders(id);
			
			if(null != cartList && cartList.size() > 0) {
				return cartList;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public List<?> GetCartById(Integer userid) {
		
		List<Addtocartmaster> cartList;
		
		try {
			
			cartList = new ArrayList<>();
			
			cartList = addtocartRepository.getAllCartItems(userid);
			
			if(cartList != null && cartList.size() > 0) {
				return cartList;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public String addCart(Addtocartmaster addtocartmaster, Integer id) {
		
		Calendar calobj = Calendar.getInstance();
		
		try {
			
			if(null != String.valueOf(id)) {
				
				if(null == addtocartRepository.getMaxId()) {
					addtocartmaster.setAddcartid(1);
				} else {
					addtocartmaster.setAddcartid(addtocartRepository.getMaxId()+1);
				}
				
				if(null != addtocartmaster.getDpid()) {
					
					if(null != addtocartRepository.getExistDartproductItemId(id, addtocartmaster.getDpid())) {
						
						return "Item already added in your cart..!";
						
					} 
					
				}
				
				if(null != addtocartmaster.getDsid()) {
					
					if(null != addtocartRepository.getExistDartserviceItemId(id, addtocartmaster.getDsid())) {
						
						return "Item already added in your cart..!";
						
					}
					
				}
				
				if(null != addtocartmaster.getPpid()) {
					
					if(null != addtocartRepository.getExistPcdproductItemId(id, addtocartmaster.getPpid())) {
						
						return "Item already added in your cart..!";
						
					}
					
				}
				
				if(null != addtocartmaster.getPsid()) {
					
					if(null != addtocartRepository.getExistPcdserviceItemId(id, addtocartmaster.getPsid())) {
						
						return "Item already added in yor cart..!";
						
					}
					
				}
				
				addtocartmaster.setUserid(id);
				addtocartmaster.setDatetime(calobj.getTime());
				addtocartRepository.save(addtocartmaster);
				
				return "Item successfully added into cart..!";
				
			} else {
				
				System.out.println("User id is null..!");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
 
		return "Something went wrong..!";
		
	}

	public String deleteCartItem(Integer id, Integer itemid) {
		try {
			
			if(null != String.valueOf(id) && null != String.valueOf(itemid)) {
				
				addtocartRepository.deleteCartItem(id, itemid);
				
				return "item removed from the cart";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}
	
	public void getMultiVal(Integer userid) {
		
		List<Addtocartmaster> addtocartmasters;
		ordermaster = new Ordermaster();
		
		List<Ordermaster> orderList;
		
		Calendar calobj = Calendar.getInstance();

		inventorymaster = new Inventorymaster();
		
		dartproductmaster = new Dartproductmaster();
		
		productmaster = new Productmaster();
		
		Integer productinvid = null, dartpid = null, pcdpid = null;
		
		List<Inventorymaster> inventoryList;
		List<Dartproductmaster> dartproductList;
		List<Productmaster> pcdproductList;
		
		try {
			
			inventoryList = new ArrayList<>();
			
			addtocartmasters = new ArrayList<>();
			
			orderList = new ArrayList<>();
			
			if(null != userid) {
				
				addtocartmasters =   addtocartRepository.getAllCartItems(userid);
				
				if(null != addtocartmasters && addtocartmasters.size() > 0) {
				
					for(int i=0; i < addtocartmasters.size(); i++) {
					
						if(null == ordermasterRepository.getMaxId()) {
							ordermaster.setOid(1);
						} else {
							ordermaster.setOid(ordermasterRepository.getMaxId()+1);
						}
					
						if(null != addtocartmasters.get(i).getDpid()) {
							ordermaster.setDpid(addtocartmasters.get(i).getDpid());
							productinvid = ordermasterRepository.getDartProductInventoryTaskId(ordermaster.getDpid());
							dartpid = dartProductRepository.getDartProductid(ordermaster.getDpid());
						}
					
						if(null != addtocartmasters.get(i).getDsid()) {
							ordermaster.setDsid(addtocartmasters.get(i).getDsid());
						}
					
						if(null != addtocartmasters.get(i).getPpid()) {
							ordermaster.setPpid(addtocartmasters.get(i).getPpid());
							productinvid = ordermasterRepository.getPcdProductInventoryTaskId(ordermaster.getPpid());
							pcdpid = productRepository.getProductid(ordermaster.getPpid());
						}
					
						if(null != addtocartmasters.get(i).getPsid()) {
							ordermaster.setPsid(addtocartmasters.get(i).getPsid());
						}
					
						if(null != addtocartmasters.get(i).getVid()) {
							ordermaster.setVid(addtocartmasters.get(i).getVid());
						}
					
						if(null != addtocartmasters.get(i).getTotalproducts()) {
							ordermaster.setTotalproducts(addtocartmasters.get(i).getTotalproducts());
						}
					
						if(null != addtocartmasters.get(i).getTotalprice()) {
							ordermaster.setTotalprice(addtocartmasters.get(i).getTotalprice());
						}
					
						ordermaster.setOrderdatetime(calobj.getTime());
						
						ordermaster.setRid(userid);
			
						orderList.add(ordermaster);
						
						//ordermasterRepository.save(ordermaster);
						
						System.out.println(addtocartmasters.get(i));
						
						addtocartRepository.deleteCartItem(addtocartmasters.get(i).getUserid(), addtocartmasters.get(i).getAddcartid());
						
						if(null != productinvid) {
							inventoryList =	inventoryRepository.getInventoryList(productinvid);
						
							if(null != inventoryList && inventoryList.size() > 0) {
								for(int j=0; j<inventoryList.size(); j++) {
									inventoryServiceImpl.updateProductInventory(inventorymaster, inventoryList.get(j).getInventoryid(), inventoryList.get(j).getInventoryname(),
											inventoryList.get(j).getInventorybrand(), inventoryList.get(j).getInventorylocation(), 
											inventoryList.get(j).getInventoryquantity(), inventoryList.get(j).getInventorymimimumstock(), 
											inventoryList.get(j).getInventoryhsncode(), inventoryList.get(j).getInventorygst(), 
											inventoryList.get(j).getInventorystock(), ordermaster.getTotalproducts());
								
									if(null != dartpid) {
										
										dartproductList = new ArrayList<>();
										
										dartproductList = dartProductRepository.getDartProductById(dartpid);
										
										dartProductServiceImpl.updateDartProductInventory(dartproductmaster, 
												
												dartproductList.get(0).getPid(), dartproductList.get(0).getPname(), 
												dartproductList.get(0).getPimage(), dartproductList.get(0).getPtype(), 
												dartproductList.get(0).getPrice(), inventoryList.get(j).getInventorymimimumstock(),
												inventoryList.get(j).getInventorystock(), dartproductList.get(0).getHsncode(), 
												dartproductList.get(0).getGst(), dartproductList.get(0).getDartproductstockstatus()
												
												);
										
									}
									
									if(null != pcdpid) {
										
										pcdproductList = new ArrayList<>();
										
										pcdproductList = productRepository.getPcdProductById(pcdpid);
										
										productServiceImpl.updatePcdProductInventory(productmaster,  
												
												pcdproductList.get(0).getPid(), pcdproductList.get(0).getPname(), 
												pcdproductList.get(0).getPimage(), pcdproductList.get(0).getPtype(), 
												pcdproductList.get(0).getPrice(), inventoryList.get(j).getInventorymimimumstock(),
												inventoryList.get(j).getInventorystock(), pcdproductList.get(0).getHsncode(), 
												pcdproductList.get(0).getGst(), pcdproductList.get(0).getPcdproductstockstatus()
												
												);
										
									}
								}
							}
						}
					}	
				}
			}
			
			if(null != orderList && orderList.size() > 1) {
			
				for(int i = 0; i < orderList.size(); i++) {
					
					billServiceImpl.generateBill(orderList, billmaster, orderList.get(i).getRid(),String.valueOf(orderList.get(i).getTotalprice()));
					
				}
				
			} else {
				
				billServiceImpl.generateBill(orderList, billmaster, orderList.get(0).getRid(), String.valueOf(orderList.get(0).getTotalprice()));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
