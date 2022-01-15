import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Fatal implements ObjectFactory {
	static {

		System.out.println("datasource");

	}

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)
			throws Exception {
		HttpServletRequest sas = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		ServletContext sc = sas.getServletContext();
		ApplicationContext ns = (ApplicationContext) sc
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	
		
		DataSource ds = ns.getBean(DataSource.class);
		getUsers(ds);
		
		System.out.println(ds);
		return "hello1";
	}
	  public List<String> getUsers(DataSource ds) throws Exception {
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;
	        List<String> names = new ArrayList<>();
	        try {
	            connection = ds.getConnection();
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery("select USER_NAME from USER");
	            while (resultSet.next()) {
	                System.out.println(resultSet.getString(1));
	            }
	        } finally {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }
	        return names;
	    }
}