package com.pcdgroup.cms.PcdEcom.paytm;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CheckSumServiceHelper {

	public static String genrateCheckSum(String Key, TreeMap<String, String> paramap) throws Exception {

		StringBuilder response = getCheckSumString(paramap);
		String checkSumValue = null;
		try {
			Encryption encryption = EncryptionFactory.getEncryptionInstance("AES");

			String randomNo = CryptoUtils.generateRandomString(4);
			response.append(randomNo);

			String checkSumHash = CryptoUtils.getSHA256(response.toString());
			checkSumHash = checkSumHash.concat(randomNo);

			System.out.println("-----------------------------");
			// System.out.println(checkSumHash);
			System.out.println("-----------------------------");
			checkSumValue = encryption.encrypt(checkSumHash, Key);

			if (checkSumValue != null) {
				checkSumValue = checkSumValue.replaceAll("\r\n", "");
				checkSumValue = checkSumValue.replaceAll("\r", "");
				checkSumValue = checkSumValue.replaceAll("\n", "");
			}

		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return checkSumValue;
	}

	public String genrateCheckSum(String Key, String paramap) throws Exception {

		// StringBuilder response =
		// checkSumServiceHelper.getCheckSumString(paramap);
		StringBuilder response = new StringBuilder(paramap);
		response.append("|");
		String checkSumValue = null;
		try {
			Encryption encryption = EncryptionFactory.getEncryptionInstance("AES");

			String randomNo = CryptoUtils.generateRandomString(4);
			response.append(randomNo);

			String checkSumHash = CryptoUtils.getSHA256(response.toString());
			checkSumHash = checkSumHash.concat(randomNo);

			System.out.println("-----------------------------");
			System.out.println(checkSumHash);
			System.out.println("-----------------------------");
			checkSumValue = encryption.encrypt(checkSumHash, Key);

			if (checkSumValue != null) {
				checkSumValue = checkSumValue.replaceAll("\r\n", "");
				checkSumValue = checkSumValue.replaceAll("\r", "");
				checkSumValue = checkSumValue.replaceAll("\n", "");
			}

		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return checkSumValue;
	}

	public static StringBuilder getCheckSumString(TreeMap<String, String> paramMap) throws Exception {

		Set<String> keys = paramMap.keySet();

		StringBuilder checkSumStringBuffer = new StringBuilder("");

		TreeSet<String> parameterSet = new TreeSet<String>();
		for (String key : keys) {

			if (!("CHECKSUMHASH".equalsIgnoreCase(key))) {
				parameterSet.add(key);
			}

		}
		for (String paramName : parameterSet) {

			String value = paramMap.get(paramName);
			if (value == null || value.trim().equalsIgnoreCase("NULL")) {
				value = "";
			}
			checkSumStringBuffer.append(value).append("|");

		}
		return checkSumStringBuffer;
	}

	public static boolean verifycheckSum(String masterKey, TreeMap<String, String> paramap, String responseCheckSumString)
			throws Exception {

		boolean isValidChecksum = false;
		StringBuilder response = getCheckSumString(paramap);
		Encryption encryption = EncryptionFactory.getEncryptionInstance("AES");

		String responseCheckSumHash = encryption.decrypt(responseCheckSumString, masterKey);

		String randomStr = getLastNChars(responseCheckSumHash, 4);
		String payTmCheckSumHash = calculateRequestCheckSum(randomStr, response.toString());

		if (null != responseCheckSumHash && null != payTmCheckSumHash) {
			if (responseCheckSumHash.equals(payTmCheckSumHash)) {
				isValidChecksum = true;
			}

		}
		return isValidChecksum;
	}

	public static String getLastNChars(String inputString, int subStringLength) {
		if (null != inputString && inputString.length() > 0) {
			int length = inputString.length();
			if (length <= subStringLength) {
				return inputString;
			}
			int startIndex = length - subStringLength;
			return inputString.substring(startIndex);
		} else {
			return "";
		}
	}

	private static String calculateRequestCheckSum(String randomStr, String checkSumString) throws Exception {

		String reqCheckSumValue = checkSumString;

		String checkSumHash = CryptoUtils.getSHA256(reqCheckSumValue.concat(randomStr));
		checkSumHash = checkSumHash.concat(randomStr);
		return checkSumHash;
	}

}
