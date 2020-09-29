package com.wawa.deeplink;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import org.apache.commons.codec.binary.Base64;
public class Main {
	
	public static void main(String[] args) throws Exception {
		try {
			String originalInput = "test input";
			String encodedString = new String(Base64.encodeBase64(originalInput.getBytes()));
			System.out.println(encodedString);
			String decodedString = new String(Base64.decodeBase64(encodedString.getBytes()));
			System.out.println(decodedString);
		     
		    }
		    catch (Exception e){
		     System.out.println("Error");
		    }
    }
	
	public static String encode(String key, String data) throws Exception {
	    Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
	    SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"),
	            "HmacSHA256");
	    sha256_HMAC.init(secret_key);
	     
	    byte[] payload =sha256_HMAC.doFinal(data.getBytes("UTF-8"));
	    return new String(Hex.encodeHex(payload));
	}
	public static String decode(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"),
                "HmacSHA256");
        sha256_HMAC.init(secret_key);
         
        // Remove the 64 bit encoding
        byte[] payload = Hex.decodeHex(data.toCharArray());
		return payload.toString();
	}

}
