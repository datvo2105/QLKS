/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vogiadat
 */
public class RSA {

	KeyPair key;

	public RSA() throws NoSuchAlgorithmException {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(1024);
		this.key = generator.generateKeyPair();
	}

	public String parserString(byte[] value) {
		return Base64.getEncoder().encodeToString(value);
	}

	public byte[] parserByte(String value) {
		return Base64.getDecoder().decode(value);
	}

	public String setPubKey() {
		return parserString(key.getPublic().getEncoded());
	}

	public String setPriKey() {
		return parserString(key.getPrivate().getEncoded());
	}

	public PublicKey getPubKey(String key) throws InvalidKeySpecException {
		byte[] publicKey = parserByte(key);
		try {
			return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKey));
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public PrivateKey getPriKey(String key) throws InvalidKeySpecException {
		byte[] privateKey = parserByte(key);
		try {
			return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKey));
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public String encrypt(String key, String msg) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, getPubKey(key));
		return parserString(cipher.doFinal(msg.getBytes()));
	}

	public String decrypt(String key, String encryptedMsg) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, getPriKey(key));
		byte[] decryptedBytes = cipher.doFinal(parserByte(encryptedMsg));
		return new String(decryptedBytes);
	}
}
