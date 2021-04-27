package com.test.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {
		
//		
//		List<String> streamGenerated = Stream.generate(() -> "element").limit(10).collect(Collectors.toList());
//		streamGenerated.forEach(s -> {
//			System.out.println(s);
//		});
		
		Stream.generate(() -> "amit").limit(10);
		
//		list.stream().filter()/skip()/distinct(). then
		
//		System.out.println(Arrays.asList("spring", "node", "test").stream().filter(f -> f.length()>4).findFirst().get());
		
//		System.out.println(Arrays.asList("spring","springtestcollectors", "node", "test").stream().filter(f -> f.length()>4).collect(Collectors.joining(", ")));
		
		List<List<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(2);
		lists.add(list1);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(4);
		list2.add(5);
		list2.add(3);
		lists.add(list2);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(10);
		list3.add(11);
		lists.add(list3);
		
//		System.out.println(lists.stream().filter(list -> list.size()>2).collect(Collectors.toSet()));
				

//		System.out.println(lists.stream().filter(list-> list.size()>2).flatMap(element-> element.stream()).collect(Collectors.summingInt(a->a*2)));
//		System.out.println(lists.stream().filter(a->a.size()>2).flatMap(list -> list.stream()).collect(Collectors.toList()));
		
		
		
		System.out.println(lists.stream().filter(a->a.size()>2).flatMap(list -> list.stream()).map(a->a*2).findFirst().get());
		
		
//		FlatMap
//		Merge 2 list into 1 and returns the sum of mod 2 of each number
		System.out.println(lists.stream().flatMap(list -> list.stream()).collect(Collectors.summingInt(a->a%2)).intValue());
		
		
//		Reduction 
//		Add 23 to the sum of the list
		System.out.println(Arrays.asList(1,1,1).stream().reduce(23, ((a,b) -> a+b)));
		
		
//		Matching
		
		System.out.println(Arrays.asList("spring", "node", "test").stream().anyMatch(str -> str.startsWith("s")));
		System.out.println(Arrays.asList("spring", "node", "test").stream().allMatch(str -> str.startsWith("s")));
		System.out.println(Arrays.asList("spring", "node", "test").stream().noneMatch(str -> str.startsWith("s")));
		
	}
}
