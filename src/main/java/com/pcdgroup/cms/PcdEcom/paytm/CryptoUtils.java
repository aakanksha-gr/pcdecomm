package com.pcdgroup.cms.PcdEcom.paytm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class CryptoUtils {

	public static String getHashFromSHA(String value) throws Exception {

		String hashValue = "";

		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		hashValue = byteArray2Hex(messageDigest.digest(value.getBytes()));

		return hashValue;
	}

	/**
	 * This method is used to convert the byte array into Hexa format.
	 * 
	 * @param hash
	 *            - byte array to be converted into Hexa format.
	 * 
	 * @return String - return the Hexa Value.
	 * 
	 */
	private static String byteArray2Hex(byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			
			formatter.format("%02x", b);
		}
		return formatter.toString();
	}

	/**
	 * This method will generate random string based on given length.
	 * 
	 * @param length
	 *            - length of the String.
	 * @return the string
	 */
	public static String generateRandomString(int length) {
		String ALPHA_NUM = "9876543210ZYXWVUTSRQPONMLKJIHGFEDCBAabcdefghijklmnopqrstuvwxyz!@#$&_";
		StringBuffer sb = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			int ndx = (int) (Math.random() * ALPHA_NUM.length());
			sb.append(ALPHA_NUM.charAt(ndx));
		}

		return sb.toString();
	}
	public static String getSHA256(String value) throws SecurityException {

		String hashValue = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			hashValue = byteArray2Hex(messageDigest.digest(value.getBytes()));
		} catch (NoSuchAlgorithmException e) {

			throw new SecurityException(e.getMessage(), e);
		}

		return hashValue;
	}
	
	
	public static String getLastNChars(String inputString,int subStringLength)
	{
		if(null != inputString && inputString.length() > 0)
		{	
		   int length = inputString.length();
		    if(length <= subStringLength){
		    	return inputString;	
		    }
		    int startIndex = length - subStringLength;
		    return inputString.substring(startIndex);
		}else
		{
			return "";
		}
		
	}
	
}
