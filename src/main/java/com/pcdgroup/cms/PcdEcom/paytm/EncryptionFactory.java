package com.pcdgroup.cms.PcdEcom.paytm;

public class EncryptionFactory {


	/**
	 * Instantiates a new encryption factory.
	 */
	private EncryptionFactory() {
	}

	/**
	 * Gets the different encryption class based on the Algorithm type.
	 * 
	 * @param algorithmType
	 *            the encryption type
	 * @return the encryption
	 */
	public static Encryption getEncryptionInstance(String algorithmType) {

		Encryption encryption = null;
		
		encryption = new AesEncryption();
		return encryption;

	}
	
}
