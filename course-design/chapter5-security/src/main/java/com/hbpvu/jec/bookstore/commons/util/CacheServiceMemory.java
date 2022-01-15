package com.hbpvu.jec.bookstore.commons.util;

import java.util.HashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Service
@Primary
public class CacheServiceMemory implements CacheServiceI {
	HashMap<String,String> cache = new HashMap<String,String>();
	@Override
	public String getCatche(String key) {
		return cache.get(key);
	}
	@Override
	public boolean catched(String key) {
		return cache.containsKey(key);
	}
	@Override
	public void catcheIt(String key,String value) {
		cache.put(key, value);
	}
}
