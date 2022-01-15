package com.hbpvu.jec.bookstore.commons.util;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;

public class CopyUtil {
	static public void copy(Object src, Object target) {
		BeanWrapper sw = new BeanWrapperImpl(src);
		BeanWrapper tw = new BeanWrapperImpl(target);
		PropertyDescriptor[] ps = sw.getPropertyDescriptors();
		for(PropertyDescriptor p : ps) {
			if(p.getName().equals("class"))
				continue;
			String pn = p.getName();
			Object pv = sw.getPropertyValue(pn);
			tw.setPropertyValue(pn, pv);
		}
	}
	static public void main(String[] ss) {
		Product src = new Product();
		src.setProductId("iii");
		Product target = new Product();
		CopyUtil.copy(src, target);
	}

}
