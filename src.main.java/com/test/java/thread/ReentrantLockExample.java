package com.test.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.geeksforgeeks.org/reentrant-lock-java/
 * 
 * @author amit
 *
 */
public class ReentrantLockExample implements Runnable{

	String name;
	ReentrantLock mutex;
	
	public ReentrantLockExample(ReentrantLock mutex, String name) {
		this.mutex = mutex;
		this.name = name;
	}
	
	public void run() {
		
		try {
			mutex.lock();
			for(int i=0; i<=2; i++) {
				System.out.println(i+ " lock1");
			}
			System.out.println(mutex.getHoldCount());
			try {
				mutex.lock();
				for(int i=0; i<=2; i++) {
					System.out.println(i+ " lock2");
				}
				
				System.out.println(mutex.getHoldCount());
			}catch(Exception e) {
				
			}finally {
				mutex.unlock();
			}
		}catch(Exception e) {
			
		}finally {
			mutex.unlock();
		}
	}
	
	public static void main(String[] args) {
		
		ReentrantLock mutex = new ReentrantLock();
		ReentrantLockExample work1 = new ReentrantLockExample(mutex, "job1");
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(work1);
		executor.shutdown();
	}
	
}
