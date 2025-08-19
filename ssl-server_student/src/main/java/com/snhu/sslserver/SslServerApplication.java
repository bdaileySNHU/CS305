package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}
//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";
@RestController
class ServerController{
    @RequestMapping("/hash")
    public String myHash(){

    	
    	try {
        	String data = "Hello Bryan Dailey!";
        	StringBuilder hash_string = new StringBuilder();
        	byte[] hash = null;
        	
        	//Create the hash from String data.
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(data.getBytes());
			hash = md.digest();
			
			//Convert the hash to a string for display.

            for (byte b : hash) {
                hash_string.append(String.format("%02x", b));
            }

            
            
	        return "<p>data: "+data + "<p>hash: " + hash_string;
	    
		} catch (NoSuchAlgorithmException e) {
			return "Error: " + e.getMessage();
		}
    }

}
