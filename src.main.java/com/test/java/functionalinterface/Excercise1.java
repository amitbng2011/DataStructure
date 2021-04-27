package com.test.java.functionalinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Excercise1 {

	public static void main(String[] args) {
		
		List<Person> lists = Arrays.asList(
				new Person("amit", 1),
				new Person("djjhd", 3),
				new Person("dbewj", 2),
				new Person("yeend", 8)
				);
		
//		Sort by name
		
//		Collections.sort(lists, (p1, p2)-> p1.getName().compareTo(p2.getName())); // Lambda way
//		
		lists.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println); // using stream
		
		
		
//		print if strts with a
		
		lists.stream().filter(a -> a.getName().startsWith("a")).forEach(System.out::println);
		
		
		List<String> list = Arrays.asList(
				"amit",
				"dswd",
				"wswwd",
				"qwqqaaw"
				);
		list.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
				
		Thread t = new Thread(()->System.out.println());
		t.start();
	}
}
