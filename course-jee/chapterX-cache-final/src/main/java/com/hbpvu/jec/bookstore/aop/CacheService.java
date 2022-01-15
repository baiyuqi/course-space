package com.hbpvu.jec.bookstore.aop;

public interface CacheService {
	abstract  void cacheIt(String key, Object result) ;

	abstract  Object getCached(String key);

	abstract  boolean cached(String key);
}
