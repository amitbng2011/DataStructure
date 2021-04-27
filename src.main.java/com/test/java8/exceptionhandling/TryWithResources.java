package com.test.java8.exceptionhandling;

import java.io.Closeable;

/**
 * 
 * Try-With-Resources: Allows us to declare resources to be used in try block with assurance that resource will be 
 * closed after block execution.
 * 
 * This happens because all the resources uses either Closable or AutoCloseable interface which has close() to override
 * 
 * Resource closing execution order: 
 * 		Resource opened first would be closed last and vice-versa.
 * 
 * We can still have catch and final as normal try catch block
 * 
 * Closable and AutoCloseable, both works fine.
 * 
 * Create customized resource which can be used as try with Resource: 
 * 		Resource has to either implement Closable or AutoCloseable
 * 
 * @author amit
 *
 */
public class TryWithResources {

	public static void main(String[] args) throws Exception {
		
		try(MyClosable closeable = new MyClosable();
				MyAutoCloseable myAutoCloseable = new MyAutoCloseable()) {
			System.out.println("Working on Try with Resources ");
		}
	}
}

class MyClosable implements Closeable{

	@Override
	public void close() {

		System.out.println("MyClosable resource clsoed usign Closeable");
	}
	
}

class MyAutoCloseable implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("MyAutoCloseable resource clsoed usign AutoCloseable");
	}
	
}