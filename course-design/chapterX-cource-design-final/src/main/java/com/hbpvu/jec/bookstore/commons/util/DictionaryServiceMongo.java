package com.hbpvu.jec.bookstore.commons.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
@Service

public class DictionaryServiceMongo implements DictionaryServiceI {
	@Autowired MongoTemplate temp;
	
	 public String find(Class<?> entityType, String id, String nameFieldName) {
		Object target = temp.findById(id, entityType);
		BeanWrapper wrapper = new BeanWrapperImpl(target);
		Object rst = wrapper.getPropertyValue(nameFieldName);
		return (String) rst;
	}
}
