package com.hbpvu.jec.bookstore.commons.util;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;
@Service("proxy")
public class DictionaryServiceProxy implements DictionaryServiceI {
	@Autowired DictionaryServiceMicro micro;
	@Autowired DictionaryServiceMicro db;
	
	Set<Class> dbtypes = new TreeSet<Class>();
	
	@Override
	public String find(Class<?> entityType, String id, String nameFieldName) {
		if(dbtypes.contains(Product.class))
			return db.find(entityType, id, nameFieldName);
		else
			return micro.find(entityType, id, nameFieldName);
	}

}
