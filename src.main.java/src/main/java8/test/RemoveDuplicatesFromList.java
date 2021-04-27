package src.main.java8.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {

	public static void main(String[] args) {
		List<Integer> listWithDuplicates = new ArrayList<>();
		listWithDuplicates.add(5);
		listWithDuplicates.add(2);
		listWithDuplicates.add(3);
		listWithDuplicates.add(2);
		listWithDuplicates.add(1);
		listWithDuplicates.add(1);
		
		//Java 8 to have distinct elements or remove duplicate elements
		List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
			     .distinct()
			     .collect(Collectors.toList());
		
		System.out.println(listWithoutDuplicates);
	}
	
	/**
	 * @Desc: Keep only k elements in the list and remove if it is more than that.
	 * 	Sequence of the collections should be same
	 * 
	 * @param list
	 * @param k
	 * @return
	 */
	public List<Integer> keepMaxKElementsInList(List<Integer> list, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> ans = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			map.put(list.get(i), map.getOrDefault(list.get(i), 0)+1);
			if(map.get(list.get(i))<=k) {
				ans.add(list.get(i));
			}
		}
		return ans;
	}
}
