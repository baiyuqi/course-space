package com.xkcoding.cache.redis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool {

	public static void main(String[] args) {
		Thread t = new Thread() {

			@Override
			public void run() {
				System.out.println("ddddd");
			}
			
		};
		
		 t.start();
		 

	}

}
