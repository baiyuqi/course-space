package com.hbpvu.jec.chapter0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter0Application {

	public static void main(String[] args) {
		
		 //System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
		//   System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
		
		//System.setProperty("log4j2.formatMsgNoLookups", "false");
		
		SpringApplication.run(Chapter0Application.class, args);
	}
}
