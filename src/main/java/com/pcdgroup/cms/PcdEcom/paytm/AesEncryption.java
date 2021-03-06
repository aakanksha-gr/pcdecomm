package com.pcdgroup.cms.PcdEcom.paytm;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import com.pcdgroup.cms.PcdEcom.paytm.EncryptConstants;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import com.pcdgroup.cms.PcdEcom.paytm.Encryption;

public class AesEncryption implements Encryption {


	private final BASE64Encoder base64Encoder = new BASE64Encoder();
	private final BASE64Decoder base64Decoder = new BASE64Decoder();

	private final byte[] ivParamBytes = {'@', '@', '@', '@', 
			 '&', '&', '&', '&',
			 '#', '#', '#', '#',
			 '$', '$', '$', '$'};

	@Override
	public String encrypt(String toEncrypt, String key) throws Exception {
		String encryptedValue = "";
		//Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance(EncryptConstants.ALGTHM_CBC_PAD_AES,EncryptConstants.ALGTHM_PROVIDER_BC);
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), EncryptConstants.ALGTHM_TYPE_AES),new IvParameterSpec(ivParamBytes));
		encryptedValue = base64Encoder.encode(cipher.doFinal(toEncrypt.getBytes()));
		return encryptedValue;
	}
	
	@Override
	public String decrypt(String toDecrypt, String key) throws Exception {

		String decryptedValue = "";
		//Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance(EncryptConstants.ALGTHM_CBC_PAD_AES,EncryptConstants.ALGTHM_PROVIDER_BC);
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), EncryptConstants.ALGTHM_TYPE_AES),new IvParameterSpec(ivParamBytes));
		decryptedValue = new String(cipher.doFinal(base64Decoder.decodeBuffer(toDecrypt)));
		
		return decryptedValue;
	}


}
