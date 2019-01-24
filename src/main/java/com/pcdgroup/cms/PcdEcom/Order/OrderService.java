package com.pcdgroup.cms.PcdEcom.Order;

import java.util.HashMap;
import java.util.List;

public interface OrderService {

	public List<?> getOrderById(Integer id);
	public String addOrder(Ordermaster ordermaster, Integer id);
	public List<?> getAllPendingorders(Integer index);
	public String cancleOrder(Integer orderid, Integer userid);
	public List<Ordermaster> getAllOrderByBrand(String brand);
	public List<?> viewOrderWithUserdetails(Integer userid);
	public List<?> getOrdersByMonths(Integer index);
	public HashMap<?, ?> getOrderIncomeByMonthYear(OrderincomecountBean orderincomecountBean);
	public List<?> viewTotalOrdersInSingleMonth(OrderincomecountBean orderincomecountBean);
	public HashMap<?, ?> getOrderIncomeByYear(OrderincomecountBean orderincomecountBean);
	List<?> getAllOrders(Integer index);
	
}
