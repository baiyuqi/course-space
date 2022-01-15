package com.hbpvu.jec.bookstore.commons.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Service

public class DictionaryServiceDB implements DictionaryServiceI {
	@PersistenceContext EntityManager em;
	
	 public String find(Class<?> entityType, String id, String nameFieldName) {
		Object target = em.find(entityType, id);
		BeanWrapper wrapper = new BeanWrapperImpl(target);
		Object rst = wrapper.getPropertyValue(nameFieldName);
		return (String) rst;
	}
}
