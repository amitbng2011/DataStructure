package com.test.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://www.geeksforgeeks.org/thread-pools-java/
 * 
 * @author amit
 *
 */
public class ThreadPools implements Runnable{

	String name;
	public ThreadPools(String name) {
		this.name = name;
	}
	public void run() {
		for(int i=0; i<2; i++) {
			System.out.println(name +" "+ i);
		}
	}
	
	public static void main(String[] args) {
		ThreadPools t1 = new ThreadPools("Thread1");
		ThreadPools t2 = new ThreadPools("Thread2");
		ThreadPools t3 = new ThreadPools("Thread3");
		ThreadPools t4 = new ThreadPools("Thread4");
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(t1);
		executor.execute(t2);
		executor.execute(t3);
		executor.execute(t4);
		
		executor.shutdown();
	}
}
