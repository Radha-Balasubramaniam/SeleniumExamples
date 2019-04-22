package com.ca.tools.docops.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * Utill for Encryption and Decryption of passwords
 * 
 * @author Team - Tools - Development <Team-Tools-Development@ca.com>
 *
 */
public class CryptoUtil {


	public  CryptoUtil() {
	}

	/*
	 * Decrypt input by using chiper text and algorithm
	 */
	public String decrypt(String input) {
		String decrptedInput = input;

		try {
			// Create the cipher
			Cipher desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			// Initialize the same cipher for decryption
			desCipher.init(Cipher.DECRYPT_MODE, getSecretKey());
			// Removing the delimiters of the input
			// Decrypted text
			byte[] textDecrypted = desCipher.doFinal(toByteArray(input));
			// Converting bytes to string
			decrptedInput = new String(textDecrypted);
		} catch (NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException |

				NoSuchPaddingException | IOException exception) {
			// LOGGER.error("Exception occured in decrypt() method of CyptoUtil,
			// in decryption process {}", exception);
		}

		return decrptedInput;
	}

	/*
	 * Encrypt input by using chiper text and alogrithm
	 */
	public static String encrypt(String input) throws IOException {

		String encryptedValue = input;
		try {
			// Create the cipher
			Cipher desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			// Initialize the cipher for encryption
			desCipher.init(Cipher.ENCRYPT_MODE, getSecretKey());

			// converting input String to bytes
			byte[] inputInbytes = input.getBytes("UTF-8");

			// Encrypt the text
			byte[] encryptedData = desCipher.doFinal(inputInbytes);

			// Converting bytes to String
			encryptedValue = toHexString(encryptedData);

		} catch (NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| NoSuchPaddingException exception) {
			// LOGGER.error("Exception occured in encrypt() method of CyptoUtil
			// , in encryption process: {}", exception);
		}

		return encryptedValue;
	}

	/*
	 * Gets the AES encryption key, which is generated using MD5
	 */
	private static Key getSecretKey() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] keyb = "!@#$%^&&**QWERTUU".getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		return new SecretKeySpec(md.digest(keyb), "AES");
	}

	public static String toHexString(byte[] array) {
		return DatatypeConverter.printHexBinary(array);
	}

	public static byte[] toByteArray(String s) {
		return DatatypeConverter.parseHexBinary(s);
	}

}
