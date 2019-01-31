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
			
		for(int i=0; i < ordersList.size(); i++) {
				
				userid = ordersList.get(i).getRid();
				
				totalamount = String.valueOf(ordersList.get(i).getTotalprice());
				
				
				if(null != userid) {
					
					if(null != billRepository.getMaxId()) {
						
						billmaster.setBillid(billRepository.getMaxId()+1);
						
					} else {
						
						billmaster.setBillid(1);
						
					}
					
					if(null != billRepository.getMaxOrderno()) {
						
						if(i != 0 && ordersList.get(0).getOrderdatetime().getDate() == ordersList.get(i).getOrderdatetime().getDate()
								&& ordersList.get(0).getOrderdatetime().getMonth() == ordersList.get(i).getOrderdatetime().getMonth()
								&& ordersList.get(0).getOrderdatetime().getHours() == ordersList.get(i).getOrderdatetime().getHours()
								&& ordersList.get(0).getOrderdatetime().getMinutes() == ordersList.get(i).getOrderdatetime().getMinutes()
								) {
							
							System.out.println(ordersList.get(0).getOrderdatetime().getDate() +" d vs d "+ ordersList.get(i).getOrderdatetime().getDate() 
								+"-"+ordersList.get(0).getOrderdatetime().getMonth() +" mon vs mon "+ ordersList.get(i).getOrderdatetime().getMonth()
								+"-"+ordersList.get(0).getOrderdatetime().getHours() +" h vs h "+ ordersList.get(i).getOrderdatetime().getHours()
								+"-"+ordersList.get(0).getOrderdatetime().getMinutes() +" min vs min "+ ordersList.get(i).getOrderdatetime().getMinutes());
							
							billmaster.setBillno(billRepository.getMaxOrderno());
							
						} else {
							
							billmaster.setBillno(billRepository.getMaxOrderno()+1);
							
						}
						
					} else {
						
						billmaster.setBillno(1);
						
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
