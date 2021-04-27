package src.main.java8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {

	public static void main(String[] args) {
		Integer[] arr = {5,3,7,1,3,4};
//		Sorting obj = new Sorting();
//		obj.sortingArray(arr);
//		
//		for(int i : arr) {
//			System.out.print(i + " ");
//		}
		
//		Java8
		List<Integer> list = Arrays.asList(arr);
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
//		Limit the output and print just 3 elements
		System.out.println("Limit the output and print just 3 elements");
		list.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		
		System.out.println("have distinct sorted elements");
		list.stream().sorted().distinct().limit(5).forEach(System.out::println);
		
		System.out.println("count  in the array is "+list.stream().count());
	}
}
