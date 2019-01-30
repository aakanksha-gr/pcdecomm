package com.pcdgroup.cms.PcdEcom.Bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.Order.Ordermaster;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	BillRepository billRepository;
	
	public void generateBill(List<Ordermaster> ordersList, Billmaster billmaster, Integer userid, String totalamount) {
		
		if(null != userid) {
			
			for(int i=0; i < ordersList.size(); i++) {
				
				if(null != billRepository.getMaxId()) {
					
					billmaster.setBillid(billRepository.getMaxId()+1);
					
				} else {
					
					billmaster.setBillid(1);
					
				}
				
				if(null != billRepository.getMaxOrderno()) {
					
					if(ordersList.size() > 1 && ordersList.get(0).getOrderdatetime() == ordersList.get(i).getOrderdatetime()) {
						
						billmaster.setBillno(String.valueOf(billRepository.getMaxOrderno()+1));
						
					} else {
						
						billmaster.setBillno(String.valueOf(billRepository.getMaxOrderno()));
						
					}
					
				} else {
					
					billmaster.setBillno("1");
					
				}
				
				if(null != ordersList.get(i).getOid()) {
					
					billmaster.setBillorderid(ordersList.get(i).getOid());
					
				}
				
				if(null != ordersList.get(i).getRid()) {
					
					billmaster.setBillinguserid(ordersList.get(i).getRid());
					
				}
				
				if(null != totalamount && totalamount.trim().length() > 0) {
					
					billmaster.setTotalamount(totalamount);
					
				}
				
				billRepository.save(billmaster);
				
			}
			
		}
		
	}
	
}
