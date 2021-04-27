package com.test.java.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * https://dzone.com/articles/java-callable-future-understanding
 * 
 * We are creating multiple callable thread and giving to executor. 
 * Adding response of call() (future) into list
 * execution is over then iterate all the responses stored in futurelist
 * and add into final sum var.
 * 
 * By future object, we can even keep track of the progress, we can cancel the thread almost everything on runnign thread.
 * 
 * @author amit
 *
 */
public class ParallelAdderTester {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		
		for(int i=1; i<=100; i++) {
			int a = i;
			int b = i+1;
			Future<Integer> future = executor.submit(new CallableAdder(a, b));
			futureList.add(future);
			i++;
		}
		
		int sum = 0;
		
		for(Future<Integer> f : futureList) {
			try {
				sum = sum + f.get();
			}catch(Exception e) {
				
			}
			
		}
		System.out.println("sum of all the threads is "+sum);
		
		executor.shutdown();
	}
}
