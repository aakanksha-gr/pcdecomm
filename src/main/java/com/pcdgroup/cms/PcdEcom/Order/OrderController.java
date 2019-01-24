package com.pcdgroup.cms.PcdEcom.Order;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderServiceImpl orderserviceimpl;
	
	@RequestMapping(method=RequestMethod.GET, value="/viewOrders/{id}")
	public List<?> viewOrder(@PathVariable Integer id) {
		return orderserviceimpl.getAllOrders(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewOrderWithUserdetails/{userid}")
	public List<?> viewOrderWithUserdetails(@PathVariable Integer userid) {
		return orderserviceimpl.viewOrderWithUserdetails(userid);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addOrder/{id}")
	public String addOrder(@RequestBody Ordermaster ordermaster, @PathVariable Integer id) {
		return orderserviceimpl.addOrder(ordermaster, id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewAllPendingorders/{index}")
	public List<?> viewAllPendingorder(@PathVariable Integer index) {
		return orderserviceimpl.getAllPendingorders(index);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewAllOrderByBrand/{brand}")
	public List<?> viewAllOrderByBrand(@PathVariable String brand) {
		return orderserviceimpl.getAllOrderByBrand(brand);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewAllOrders/{index}")
	public List<?> viewAllOrders(@PathVariable Integer index) {
		return orderserviceimpl.getAllOrders(index);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/cancelOrder/{orderid}/{userid}")
	public String cancleOrder(@PathVariable Integer orderid, @PathVariable Integer userid) {
		return orderserviceimpl.cancleOrder(orderid, userid);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewOrdersByMonthSequence/{index}")
	public List<?> viewOrdersByMonthSequence(@PathVariable Integer index) {
		return orderserviceimpl.getOrdersByMonths(index);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/viewOrdersIncomeByMonthYear")
	public HashMap<?,?> viewOrdersIncomeByMonth(@RequestBody OrderincomecountBean orderincomecountBean) {
		return orderserviceimpl.getOrderIncomeByMonthYear(orderincomecountBean);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/viewOrdersIncomeByYear")
	public HashMap<?,?> viewOrdersIncomeByYear(@RequestBody OrderincomecountBean orderincomecountBean) {
		return orderserviceimpl.getOrderIncomeByYear(orderincomecountBean);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/viewTotalOrdersInSingleMonth")
	public List<?> viewTotalOrdersInSingleMonth(@RequestBody OrderincomecountBean orderincomecountBean) {
		return orderserviceimpl.viewTotalOrdersInSingleMonth(orderincomecountBean);
	}
	
}
