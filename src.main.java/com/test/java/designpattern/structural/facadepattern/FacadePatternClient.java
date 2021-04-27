package com.test.java.designpattern.structural.facadepattern;

/**
 * @Desc: Facade pattern is one of structural design pattern. 
 * The facade pattern is appropriate when we have a complex system that we want to expose to clients in a simplified way.
 * 
 * @author amit
 *
 */
public class FacadePatternClient {

	public static void main(String[] args) {
		
		Facade facade = new Facade();
		facade.buildCircle();;
	}
}
