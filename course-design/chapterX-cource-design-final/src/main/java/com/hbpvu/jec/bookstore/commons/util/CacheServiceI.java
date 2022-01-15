package com.hbpvu.jec.bookstore.commons.util;

public interface CacheServiceI {

	String getCatche(String key);

	boolean catched(String key);

	void catcheIt(String key, String value);

}