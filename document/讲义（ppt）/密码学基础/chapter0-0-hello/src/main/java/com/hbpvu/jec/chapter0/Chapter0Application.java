package com.hbpvu.jec.chapter0;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Chapter0Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter0Application.class, args);
	}

	
	@Bean
	TomcatServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tom = new TomcatServletWebServerFactory() {

			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint con = new SecurityConstraint();
				con.setUserConstraint("CONFIDENTIAL");
				SecurityCollection col = new SecurityCollection();
				col.addPattern("/**");
				con.addCollection(col);
				context.addConstraint(con);
			}

		};
		tom.addAdditionalTomcatConnectors(createHttpConnector());
		return tom;
	}
	private Connector createHttpConnector() {
	        Connector connector =
	                new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
	        connector.setScheme("http");
	        connector.setSecure(false);
	        connector.setPort(8080);
	        connector.setRedirectPort(8443);
	        return connector;
	    }
}