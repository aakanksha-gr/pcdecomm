package com.pcdgroup.cms.PcdEcom.Paytmpayment;

import java.util.TreeMap;

import org.springframework.stereotype.Service;

//import com.paytm.pg.merchant.CheckSumServiceHelper;

@Service
public class ChecksumGeneration {
	
	/*//Below parameters provided by Paytm
	private static String MercahntKey = "XXXXXXXXXXXXXXXX";
	private static String MID = "XXXXXXXXXXXXXXXXXXXXXXXX"; 
	;
	private static String INDUSTRY_TYPE_ID = "XXXXXXXXXXXX";
	private static String CHANNLE_ID = "WAP";
	private static String WEBSITE = "XXXXXXXXXX";
	private static String CALLBACK_URL = "XXXXXXXXXXXXXX";
		
	public TreeMap<String, String> GenerateChecksum(ChecksumGenerationBean checksumGenerationBean) {
		
		TreeMap<String,String> paramMap = new TreeMap<String,String>();
		paramMap.put("MID" , checksumGenerationBean.getMid());
		paramMap.put("ORDER_ID" , checksumGenerationBean.getOrderid());
		paramMap.put("CUST_ID" , checksumGenerationBean.getCustid());
		paramMap.put("INDUSTRY_TYPE_ID" , checksumGenerationBean.getIndustrytypeid());
		paramMap.put("CHANNEL_ID" , checksumGenerationBean.getChannelid());
		paramMap.put("TXN_AMOUNT" , checksumGenerationBean.getTxnamount());
		paramMap.put("WEBSITE" , checksumGenerationBean.getWebsite());
		paramMap.put("EMAIL" , checksumGenerationBean.getEmail());
		paramMap.put("MOBILE_NO" , checksumGenerationBean.getMobileno());
		paramMap.put("CALLBACK_URL" , checksumGenerationBean.getCallbackurl());
		
		try{
		String checkSum =  CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MercahntKey, paramMap);
		paramMap.put("CHECKSUMHASH" , checkSum);
		
		System.out.println("Paytm Payload: "+ paramMap);
		
		return paramMap;
		
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return null;
		
	}*/
	
}
