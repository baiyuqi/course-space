package com.hbpvu.jec.log.aop;

public class MyBusinssLogic {
	
	private MyBusinssLogic() {
		
	}
	static MyBusinssLogic instance;
	static {
		instance = new MyBusinssLogic();
	}
	static public MyBusinssLogic getInstance() {
		return instance;
	}
	public String logicName() {
		return "kkk";
	}


}
