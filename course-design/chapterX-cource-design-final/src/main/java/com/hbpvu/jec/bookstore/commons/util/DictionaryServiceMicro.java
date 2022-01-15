package com.hbpvu.jec.bookstore.commons.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Service
@Primary
public class DictionaryServiceMicro implements DictionaryServiceI {
	/*
	 * feign
	 * 
	 * */
	
	 public String find(Class<?> entityType, String id, String nameFieldName) {
	
		return null;
	}
}
