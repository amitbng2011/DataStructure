package src.main.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Partition divided list into partition based on condition given.
 * Same thing can be achieved by filter but you need to call that many number times to get all the partition
 *
 */
public class Partition {

	public static void main(String[] args) {
		
//		Divide list into 2. 1st greater than 10 and remaining less than 10
		List<Integer> list = Arrays.asList(12,11,90,100,32);
		
		Map<Boolean, List<Integer>> partitionMap = list.stream().collect(Collectors.partitioningBy((Integer i)-> i<10));
		
		partitionMap.forEach((Boolean key, List<Integer> partition)->System.out.println(key+ " *** "+partition));
		
//		Count the numbers greater than 10 and less than 10
		
		Map<Boolean, Long> partitionCountMap = list.stream().collect(Collectors.partitioningBy((Integer i)->(i>10), Collectors.counting()));
		
		partitionCountMap.forEach((Boolean key, Long count)-> System.out.println(key+" *** "+count));
		
	}
}
