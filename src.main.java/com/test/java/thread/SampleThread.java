package com.test.java.thread;

public class SampleThread implements Runnable{

	Thread thread;
	private String threadName;

	@Override
	public void run() {

		for(int i=0; i<5; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {

		SampleThread obj = new SampleThread("Thread-1");
		Thread t1 = new Thread(obj);
		t1.start();
	}

	public SampleThread(String thredName) {
		this.threadName= thredName;
		System.out.println("Creating " +  threadName );
	}

}
