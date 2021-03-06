package com.pcdgroup.cms.PcdEcom.paytm;

public interface Encryption {
	

	/**
	 * This method will encrypt the data based on the given key.
	 *
	 * @param toEncrypt the to encrypt
	 * @param password the password
	 * @return the string
	 * @throws SecurityException the security exception
	 */
	public String encrypt(String toEncrypt,String key) throws Exception;

	
	/**
	 * This method will decrypt the data based on the given key.
	 *
	 * @param toEncrypt the to encrypt
	 * @param password the password
	 * @return the string
	 * @throws SecurityException the security exception
	 */
	public String decrypt(String toDecrypt,String key) throws Exception;

}
