package com.pcdgroup.cms.PcdEcom.Paytmpayment;

import java.util.Map;
import java.util.TreeMap;
import com.pcdgroup.cms.PcdEcom.paytm.CheckSumServiceHelper;

public class ChecksumVerification {
	
	private static String MercahntKey = "XXXXXXXXXXXXXXXX";
	
	public void checkGeneratedChecksum() {
		
		String paytmChecksum = "";
		
		Map<String, String> mapData = new  TreeMap<String,String>();
		
		TreeMap<String, String> paytmParams = new  TreeMap<String,String>();
		
		for (Map.Entry<String, String> entry : mapData.entrySet())
		{   
		    if(entry.getKey().equals("CHECKSUMHASH")){
				paytmChecksum = entry.getKey();
				System.out.println(paytmChecksum);
			}else{
				paytmParams.put(entry.getKey(), entry.getValue());
			}
		    
		}
		
		boolean isValideChecksum = false;
		try{
			
			isValideChecksum = CheckSumServiceHelper.verifycheckSum(MercahntKey, paytmParams, paytmChecksum);
			
			System.out.println(isValideChecksum);
			
			// if checksum is validated Kindly verify the amount and status 
			// if transaction is successful 
			// kindly call Paytm Transaction Status API and verify the transaction amount and status.
			// If everything is fine then mark that transaction as successful into your DB.
			
			
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}
	
}
