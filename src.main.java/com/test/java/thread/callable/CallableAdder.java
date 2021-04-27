package com.test.java.thread.callable;

import java.util.concurrent.Callable;

public class CallableAdder implements Callable<Integer>{

	Integer operand1;
	Integer operand2;

	public CallableAdder(Integer operand1,Integer operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	public Integer call() throws Exception{
		return operand1+operand2;
	}
}