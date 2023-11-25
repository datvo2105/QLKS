/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author vogiadat
 */
public class AES {

	SecretKey key;
	Cipher cipher;

	public AES() throws NoSuchAlgorithmException, NoSuchPaddingException {
		cipher = Cipher.getInstance("AES");
		this.key = KeyGenerator.getInstance("AES").generateKey();
	}

	public String parserString(byte[] value) {
		return Base64.getEncoder().encodeToString(value);
	}

	public byte[] parserByte(String value) {
		return Base64.getDecoder().decode(value);
	}

	public String stringKey() {
		return parserString(key.getEncoded());
	}

	public SecretKeySpec convertToKey(String key) {
		return new SecretKeySpec(parserByte(key), "AES");
	}

	public String encryptAES(String value, String stringKey) throws InvalidKeyException {
		key = convertToKey(stringKey);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encrypted = null;
		try {
			encrypted = cipher.doFinal(value.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException ex) {
			Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
		}
		return parserString(encrypted);
	}

	public String decryptAES(String encrypted, String stringKey) throws IllegalBlockSizeException, BadPaddingException {
		key = convertToKey(stringKey);
		byte[] decrypted = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			decrypted = (cipher.doFinal(parserByte(encrypted)));
		} catch (InvalidKeyException ex) {
			Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
		}
		return new String(decrypted);
	}
}
