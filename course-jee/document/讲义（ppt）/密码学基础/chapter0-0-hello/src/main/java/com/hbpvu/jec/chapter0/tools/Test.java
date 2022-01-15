package com.hbpvu.jec.chapter0.tools;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.Enumeration;

public class Test {

	public static void main(String[] args) throws Throwable {

		KeyStore ks = KeyStore.getInstance("Windows-MY");
		ks.load(null, null) ;
		Enumeration en = ks.aliases() ;
		while (en.hasMoreElements()) {
		    String aliasKey = (String)en.nextElement() ;
		     Certificate c = ks.getCertificate(aliasKey) ;
		    System.out.println("---> alias : " + aliasKey) ;
		    if (ks.isKeyEntry(aliasKey)) {
		        Certificate[] chain = ks.getCertificateChain(aliasKey);
		        System.out.println("---> chain length: " + chain.length);
		        for (Certificate cert: chain) {
		            System.out.println(cert);
		    }
		}

	}

	}
}
