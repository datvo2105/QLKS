/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

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

	public String setPubKey() {
		return Base64.getEncoder().encodeToString(key.getPublic().getEncoded());
	}

	public String setPriKey() {
		return Base64.getEncoder().encodeToString(key.getPrivate().getEncoded());
	}

	public PublicKey getPubKey(String key) throws InvalidKeySpecException {
		byte[] publicKey = Base64.getDecoder().decode(key);
		try {
			return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKey));
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public PrivateKey getPriKey(String key) throws InvalidKeySpecException {
		byte[] privateKey = Base64.getDecoder().decode(key);
		try {
			return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKey));
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public byte[] encrypt(String key, String msg) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, getPubKey(key));
		return cipher.doFinal(msg.getBytes());
	}

	public String decrypt(String key, byte[] encryptedMsg) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, getPriKey(key));
		byte[] decryptedBytes = cipher.doFinal(encryptedMsg);
		return new String(decryptedBytes);
	}
}
