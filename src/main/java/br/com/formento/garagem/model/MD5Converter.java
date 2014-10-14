package br.com.formento.garagem.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Converter {
	private static MessageDigest messageDigest;

	private static MessageDigest getMessageDigest() {
		if (messageDigest == null)
			try {
				messageDigest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				return null;
			}
		return messageDigest;
	}

	public static String getMD5(String input) {
		byte[] messageDigest = getMessageDigest().digest(input.getBytes());
		BigInteger number = new BigInteger(1, messageDigest);
		String hashtext = number.toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while (hashtext.length() < 32)
			hashtext = "0" + hashtext;

		return hashtext;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(getMD5("Javarmi.com"));
	}
}
