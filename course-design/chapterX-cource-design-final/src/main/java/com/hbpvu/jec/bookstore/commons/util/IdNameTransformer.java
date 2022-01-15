package com.hbpvu.jec.bookstore.commons.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbpvu.jec.bookstore.commons.annotation.Dictionary;

@Service
public class IdNameTransformer {
 @Autowired DictionaryServiceMongo dictionaryService;
	@Autowired  CacheServiceI cacheService;

	/*比较优势 责任分配*/
	
	String transform(Class<?> entityType, String id, String nameFieldName) {
		String key = id + "@" + entityType.getName()+ "." + nameFieldName;
		
		if(cacheService.catched(key))
			return cacheService.getCatche(key);
		
		String rst = dictionaryService.find(entityType, id,  nameFieldName);
		cacheService.catcheIt(key, rst);
		return rst;
	}

	public void fillDictionaryField(Object obj) {
		Class type = obj.getClass();
		Field[] fs = type.getDeclaredFields();
		
		BeanWrapper wrapper = new BeanWrapperImpl(obj);
		for(Field f : fs) {
			if(!f.isAnnotationPresent(Dictionary.class))
				continue;
			Dictionary anno = f.getAnnotation(Dictionary.class);
			Class<?> etype = anno.entityType();
			String idfieldname = anno.id();
			String namefieldname = anno.name();
			String id = (String) wrapper.getPropertyValue(idfieldname);
			String nameValue = transform(etype, id, namefieldname);
			wrapper.setPropertyValue(f.getName(), nameValue);
		}
		
	}
	
	public void fillDictionaryFieldList(List data) {
		for(Object o : data)
			this.fillDictionaryField(o);
	}
}
