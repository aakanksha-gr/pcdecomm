package com.pcdgroup.cms.PcdEcom.Order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.BasicRegistration.RegistrationServiceImpl;
import com.pcdgroup.cms.PcdEcom.Bill.BillServiceImpl;
import com.pcdgroup.cms.PcdEcom.Bill.Billmaster;
import com.pcdgroup.cms.PcdEcom.DartProduct.DartProductRepository;
import com.pcdgroup.cms.PcdEcom.DartProduct.DartProductServiceImpl;
import com.pcdgroup.cms.PcdEcom.DartProduct.Dartproductmaster;
import com.pcdgroup.cms.PcdEcom.Inventory.InventoryRepository;
import com.pcdgroup.cms.PcdEcom.Inventory.InventoryServiceImpl;
import com.pcdgroup.cms.PcdEcom.Inventory.Inventorymaster;
import com.pcdgroup.cms.PcdEcom.PcdProduct.ProductRepository;
import com.pcdgroup.cms.PcdEcom.PcdProduct.ProductServiceImpl;
import com.pcdgroup.cms.PcdEcom.PcdProduct.Productmaster;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrdermasterRepository ordermasterRepository;
	
	@Autowired
	RegistrationServiceImpl registrationServiceImpl; 
	
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
	public List<?> getOrderById(Integer id) {
		List<Ordermaster> orderList;
		
		try {
			
			orderList = new ArrayList<>();
			if(null != String.valueOf(id)) {
				
				orderList = ordermasterRepository.getOrderById(id);
				
				if(null != orderList && orderList.size() > 0) {
					
					return orderList;
				
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
	public String addOrder(Ordermaster ordermaster, Integer id) {
		
		Calendar calobj = Calendar.getInstance();
		
		inventorymaster = new Inventorymaster();
		
		dartproductmaster = new Dartproductmaster();
		
		productmaster = new Productmaster();
		
		billmaster = new Billmaster();
		
		Integer productinvid = null, dartpid = null, pcdpid = null;
		
		List<Inventorymaster> inventoryList;
		List<Dartproductmaster> dartproductList;
		List<Productmaster> pcdproductList;
		List<Ordermaster> orderList;
		
		try {
			
				inventoryList = new ArrayList<>();
			
				orderList = new ArrayList<>();
				
				if(null == ordermasterRepository.getMaxId()) {
				
					ordermaster.setOid(1);
				
				} else {
				
					ordermaster.setOid(ordermasterRepository.getMaxId()+1);
		
				}
			
				ordermaster.setRid(id);
				
				ordermaster.setOrderdatetime(calobj.getTime());
				
				if(null != ordermaster.getDpid()) {
					productinvid = ordermasterRepository.getDartProductInventoryTaskId(ordermaster.getDpid());
					dartpid = dartProductRepository.getDartProductid(ordermaster.getDpid());
				}
				
				if(null != ordermaster.getPpid()) {
					productinvid = ordermasterRepository.getPcdProductInventoryTaskId(ordermaster.getPpid());
					pcdpid = productRepository.getProductid(ordermaster.getPpid());
				}
				
				orderList.add(ordermaster);
				
				//ordermasterRepository.save(ordermaster);
			
				if(null != orderList && orderList.size() > 1) {
					
					for(int j=0; j<=orderList.size(); j++) {
					
						billServiceImpl.generateBill(orderList, billmaster, orderList.get(j).getRid(),String.valueOf(orderList.get(j).getTotalprice()));
						
					}
					
				} else {
					
					billServiceImpl.generateBill(orderList, billmaster, orderList.get(0).getRid(), String.valueOf(orderList.get(0).getTotalprice()));
					
				}
				
				if(null != productinvid) {
					inventoryList =	inventoryRepository.getInventoryList(productinvid);
				
					if(null != inventoryList && inventoryList.size() > 0) {
						for(int i=0; i<inventoryList.size(); i++) {
							inventoryServiceImpl.updateProductInventory(inventorymaster, inventoryList.get(i).getInventoryid(), inventoryList.get(i).getInventoryname(),
									inventoryList.get(i).getInventorybrand(), inventoryList.get(i).getInventorylocation(), 
									inventoryList.get(i).getInventoryquantity(), inventoryList.get(i).getInventorymimimumstock(), 
									inventoryList.get(i).getInventoryhsncode(), inventoryList.get(i).getInventorygst(), 
									inventoryList.get(i).getInventorystock(), ordermaster.getTotalproducts());
							
							if(null != dartpid) {
								
								dartproductList = new ArrayList<>();
								
								dartproductList = dartProductRepository.getDartProductById(dartpid);
								
								dartProductServiceImpl.updateDartProductInventory(dartproductmaster, 
										
										dartproductList.get(0).getPid(), dartproductList.get(0).getPname(), 
										dartproductList.get(0).getPimage(), dartproductList.get(0).getPtype(), 
										dartproductList.get(0).getPrice(), inventoryList.get(i).getInventorymimimumstock(),
										inventoryList.get(i).getInventorystock(), dartproductList.get(0).getHsncode(), 
										dartproductList.get(0).getGst(), dartproductList.get(0).getDartproductstockstatus()
										
										);
								
							}
							
							if(null != pcdpid) {
								
								pcdproductList = new ArrayList<>();
								
								pcdproductList = productRepository.getPcdProductById(pcdpid);
								
								productServiceImpl.updatePcdProductInventory(productmaster,  
										
										pcdproductList.get(0).getPid(), pcdproductList.get(0).getPname(), 
										pcdproductList.get(0).getPimage(), pcdproductList.get(0).getPtype(), 
										pcdproductList.get(0).getPrice(), inventoryList.get(i).getInventorymimimumstock(),
										inventoryList.get(i).getInventorystock(), pcdproductList.get(0).getHsncode(), 
										pcdproductList.get(0).getGst(), pcdproductList.get(0).getPcdproductstockstatus()
										
										);
								
							}
						}
						
					}
					
				}
				
				return "Ordered successful..!";
				
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
		
		}
	
		return "Something wents wrong..!";
		
	}

	@Override
	public List<?> getAllPendingorders(Integer index) {
		
		try {
			
			if(null != ordermasterRepository.getAllPendingorders(index) && ordermasterRepository.getAllPendingorders(index).size() > 0) {
				
				return ordermasterRepository.getAllPendingorders(index);
				
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public String cancleOrder(Integer orderid, Integer userid) {
		
		try {
			
			if(null != orderid && null != userid) {
				
				ordermasterRepository.cancleOrder(orderid, userid);
				
				return "Your order cancelled..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public List<Ordermaster> getAllOrderByBrand(String brand) {
		
		try {
			
			if(null != brand && brand.trim().length() > 0) {
				
				return ordermasterRepository.getAllOrdersByBrand(brand);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

	@Override
	public List<?> viewOrderWithUserdetails(Integer userid) {
		
		try {
		
			if(null != userid) {
			
				return ordermasterRepository.getOrderWithUserDetails(userid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}		
	
		return null;
	
	}
	
	/*@Override
	public List<Ordermaster> getTotalIncomeByMonth(Ordermaster ordermaster) {
		
		try {
				
				if(null != ordermaster.getOrderdatetime() && null != ordermaster.getOrderbrand() && null != ordermaster.getOrdertype()) {
					
					return ordermasterRepository.getTotalIncomeByMonth(ordermaster.getOrderdatetime(), ordermaster.getOrderbrand(), ordermaster.getOrdertype());
					
				}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}
	
	@Override
	public List<Ordermaster> getTotalIncomeByYear(Ordermaster ordermaster) {
		
		try {
				
				if(null != ordermaster.getOrderdatetime() && null != ordermaster.getOrderbrand() && null != ordermaster.getOrdertype()) {
					
					return ordermasterRepository.getAllTotalIncomeByYear(ordermaster.getOrderdatetime(), ordermaster.getOrderbrand(), ordermaster.getOrdertype());
					
				}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}*/

	@Override
	public List<?> getAllOrders(Integer index) {
		
		try {
			
			return ordermasterRepository.getAllOrders(index);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	public List<?> getOrdersByMonths(Integer index) {
		
		try {
			
			return ordermasterRepository.getAllOrdersByMonths(index);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	public HashMap<?,?> getOrderIncomeByMonthYear(OrderincomecountBean orderincomecountBean) {
		
		HashMap<String, String> sumofincome;
		
		try {
			
			sumofincome = new HashMap<>();
			
			if(null != orderincomecountBean.getMonth() && null != orderincomecountBean.getYear() && null != ordermasterRepository.getTotalSumOfIncomeByMonthYear(Integer.parseInt(orderincomecountBean.getMonth()), Integer.parseInt(orderincomecountBean.getYear()))) {
				
				sumofincome.put("month", orderincomecountBean.getMonth());
				
				sumofincome.put("year", orderincomecountBean.getYear());
				
				sumofincome.put("totalmonthlyincome", String.valueOf(ordermasterRepository.getTotalSumOfIncomeByMonthYear(Integer.parseInt(orderincomecountBean.getMonth()), Integer.parseInt(orderincomecountBean.getYear()))));
			
				System.out.println(sumofincome);
				
			}
			
			return sumofincome;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	public List<?> viewTotalOrdersInSingleMonth(OrderincomecountBean orderincomecountBean) {
		
		try {
			
			if(null != orderincomecountBean.getMonth()) {
			
				return ordermasterRepository.getTotalOrdersInSingleMonth(orderincomecountBean.getMonth());
			
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

	public HashMap<?, ?> getOrderIncomeByYear(OrderincomecountBean orderincomecountBean) {
		
		HashMap<String, String> sumofincome;
		
		try {
			
			sumofincome = new HashMap<>();
			
			if(null != orderincomecountBean.getYear()) {
				
				sumofincome.put("year", orderincomecountBean.getYear());
				sumofincome.put("totalyearlyincome", String.valueOf(ordermasterRepository.getTotalSumOfIncomeByYear(Integer.parseInt(orderincomecountBean.getYear()))));
				
				return sumofincome;
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
}
