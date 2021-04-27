package com.test.java.thread;

import java.util.concurrent.Semaphore;

public class PrintThePattern {

	Semaphore semCaps;
	Semaphore semSmall;

	public PrintThePattern() {
		semCaps = new Semaphore(1);
		semSmall = new Semaphore(0);
	}
	
	public static void main(String[] args) {
		PrintThePattern sp = new PrintThePattern();
	    Thread small = new Thread(new Small(sp, 10),"a");
	    Thread caps = new Thread(new Caps(sp, 10),"A");
	    small.start();
	    caps.start();
	}

	void printCaps(int num) {
		try {
			semCaps.acquire();
			System.out.println((char)('A'+num));
//			System.out.print("\nfoo");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		semSmall.release();
	}

	void printSmall(int num) {
		try {
			semSmall.acquire();
			System.out.println((char)('a'+num));
//			System.out.print("bar");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		semCaps.release();

	}
}
	class Caps implements Runnable{
		private PrintThePattern printThePattern;
		private int max;
		
		public Caps(PrintThePattern printThePattern, int max) {
			this.printThePattern = printThePattern;
			this.max = max;
		}

		@Override
		public void run() {
			for (int i = 0; i <= max; i++) {
				printThePattern.printCaps(i);
			}
		}
	}

	class Small implements Runnable{
		private PrintThePattern printThePattern;
		private int max;
		public Small(PrintThePattern printThePattern, int max) {
			this.printThePattern = printThePattern;
			this.max = max;
		}

		@Override
		public void run() {
			for (int i = 0; i <= max; i++) {
				printThePattern.printSmall(i);
			}
		}
	}
