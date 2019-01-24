package com.pcdgroup.cms.PcdEcom.Order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.BasicRegistration.RegistrationServiceImpl;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrdermasterRepository ordermasterRepository;
	
	@Autowired
	RegistrationServiceImpl registrationServiceImpl; 
	
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
		
		try {
			
				if(null == ordermasterRepository.getMaxId()) {
				
					ordermaster.setOid(1);
				
				} else {
				
					ordermaster.setOid(ordermasterRepository.getMaxId()+1);
		
				}
			
				ordermaster.setRid(id);
				
				ordermaster.setOrderdatetime(calobj.getTime());
				
				ordermasterRepository.save(ordermaster);
			
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
