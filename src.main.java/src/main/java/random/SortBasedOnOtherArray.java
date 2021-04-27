package src.main.java.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortBasedOnOtherArray {

	public static void main(String[] args) {

	}

	public static void sort(List<List<Integer>> starting, List<Integer> ending){

		List<Integer> idx = new ArrayList<>();

		for(int i=0; i<ending.size(); i++){
			idx.add(i);
		}
		Collections.sort(idx, new Comparator<Integer>() {
			@Override
			public int compare(Integer i, Integer j){
				return ending.get(i).compareTo(ending.get(j));
			}
		});


		Map<Integer, Integer> swap = new HashMap<>();
		List<Integer> from = new ArrayList<>();
		List<Integer> to = new ArrayList<>();

		for(int i=0; i<ending.size(); i++){
			int k = idx.get(i);
			while(i != k && swap.containsKey(k)){
				k = swap.get(k);
			}
			from.add(i);
			to.add(k);
			swap.put(i, k);
		}

		// now sort all the collection based on second collection

		for(List<Integer> list : starting) {
			for(int i=0; i<list.size(); i++){

				Collections.swap(list, from.get(i), to.get(i));
			}
		}
		

		
	}
}
