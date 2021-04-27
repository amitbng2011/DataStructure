package com.test.java8.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * When you need to compare objects on certain parameters then Comparator can be used.
 * Just think that Student class is given by someone else and you don't have control to modify that 
 * but requirement is sort based on some param. 
 *
 */
public class ComparatorTest {

	public static void main(String[] args) {
		List<Student1> students = new ArrayList<Student1>() {
			{
				add(new Student1("xyz", 12, "San Jose"));
				add(new Student1("abc", 10, "San Jose"));
				add(new Student1("yrh", 25, "Sunnyvale"));
			}
		};

		System.out.println("Before Sorting");
		students.stream().forEach(System.out::println);
		
		Collections.sort(students, new Comparator<Student1>() {

			@Override
			public int compare(Student1 o1, Student1 o2) {
				if(o1.getAge()>o2.getAge())
					return 1;
				else if(o1.getAge()==o2.getAge())
					return 0;
				else
					return -1;
			}

		});
		System.out.println("After Sorting");
		students.stream().forEach(System.out::println);
	}
}


class Student1{
	
	private String name;
	private int age;
	private String city;
	
	public Student1(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", city=" + city + "]";
	}
}