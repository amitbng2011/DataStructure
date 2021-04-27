package com.test.java.functionalinterface;

public class Geeting {

	public static void main(String[] args) {
		
		GreetingInterface test = () -> {
			System.out.println("greeting");
		};
		
		test.greet();
		
		
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("runnable interface");
			}
			
		});
		t1.run();
		
		Thread t2 = new Thread(()-> System.out.println("Lambda runnable interface "));
		t2.run();
		
	}
}

interface GreetingInterface{
	public void greet();
}
