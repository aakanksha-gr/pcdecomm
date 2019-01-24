package com.pcdgroup.cms.PcdEcom.Addtocart;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.Order.Ordermaster;
import com.pcdgroup.cms.PcdEcom.Order.OrdermasterRepository;

@Service
public class AddtocartServiceImpl implements AddtocartService {

	@Autowired
	AddtocartRepository addtocartRepository;
	
	@Autowired
	OrdermasterRepository ordermasterRepository;
	
	Ordermaster ordermaster;
	
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
		
		Calendar calobj = Calendar.getInstance();
		
		try {
			
			addtocartmasters = new ArrayList<>();
			
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
						}
					
						if(null != addtocartmasters.get(i).getDsid()) {
						ordermaster.setDsid(addtocartmasters.get(i).getDsid());
						}
					
						if(null != addtocartmasters.get(i).getPpid()) {
						ordermaster.setPpid(addtocartmasters.get(i).getPpid());
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
						
						ordermasterRepository.save(ordermaster);
							
						System.out.println(addtocartmasters.get(i));
						
					}	
				
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
