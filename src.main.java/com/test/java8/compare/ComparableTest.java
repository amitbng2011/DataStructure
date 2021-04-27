package com.test.java8.compare;

import java.util.ArrayList;
import java.util.List;

public class ComparableTest{

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<Student>() {
			{
				add(new Student("xyz", 12, "san jose"));
				add(new Student("abc", 10, "san jose"));
				add(new Student("yrh", 25, "Sunnyvale"));
			}
		};
		students.stream().sorted().forEach(System.out::println);
		
	}
}

class Student implements Comparable<Student>{
	
	private String name;
	private int age;
	private String city;
	
	public Student(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public int compareTo(Student s1) {
		if(this.age>s1.getAge())
			return 1;
		else if(this.age==s1.getAge())
			return 0;
		else
			return -1;
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