package com.test.java.thread;

/**
 * https://www.tutorialspoint.com/java/java_thread_deadlock.htm
 * 
 * @author amit
 */
public class DeadLock {

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		thread1.start();
		thread2.start();
	}

	private static class Thread1 extends Thread{

		public void run() {
			synchronized(lock1) {

				System.out.println("Thread1: is holding lock1");
				try {
					Thread.sleep(10);
				}catch (InterruptedException e) {
				}
				
				System.out.println("Thread 1: Waiting for lock 2...");
				
				synchronized(lock2) {
					System.out.println("Thread1: is holding lock1 and locl2");
				}
			}
		}
	}

	private static class Thread2 extends Thread{

		public void run() {
			synchronized(lock2) {
				System.out.println("Thread2: is holding lock2");
				try {
					Thread.sleep(10);
				}catch (Exception e) {

				}
				System.out.println("Thread2: waiting for lock1");
				synchronized(lock1) {
					System.out.println("Thread2: is holding lock1 and lock2");
				}
			}
		}
	}
}
