package com.wawa.deeplink;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController{
	 private final EmployeeRepository repository;

	  EmployeeController(EmployeeRepository repository) {
	    this.repository = repository;
	  }

	  // Aggregate root

	  @GetMapping("/employees")
	  List<Employee> all() {
	    return repository.findAll();
	  }

	  @PostMapping("/employees")
	  Employee newEmployee(@RequestBody Employee newEmployee) {
	    return repository.save(newEmployee);
	  }

	  // Single item

	  @GetMapping("/employees/{id}")
	  Optional<Employee> one(@PathVariable Long id) throws UnsupportedEncodingException {
		  byte[] hmacSha256 = calcHmacSha256("secret123".getBytes("UTF-8"), id.toString().getBytes("UTF-8"));
		  System.out.println(String.format("Hex: %032x", new BigInteger(1, hmacSha256)));
		  
	    return repository.findById(id);
	      
	  }
	  
	
	  
	   public byte[] calcHmacSha256(byte[] secretKey, byte[] message) {
		    byte[] hmacSha256 = null;
		    try {
		      Mac mac = Mac.getInstance("HmacSHA256");
		      SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
		      mac.init(secretKeySpec);
		      hmacSha256 = mac.doFinal(message);
		    } catch (Exception e) {
		      throw new RuntimeException("Failed to calculate hmac-sha256", e);
		    }
		    return hmacSha256;
		  }

}
