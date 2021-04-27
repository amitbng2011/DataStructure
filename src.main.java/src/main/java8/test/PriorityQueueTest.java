package src.main.java8.test;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		int[] arr = new int[] {3,2,5,6,4,5};
		
//		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a)); //reverse order
//		PriorityQueue<Integer> pq = new PriorityQueue<>(); // asc order
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // reverse order.. desc order
		
		for(int i : arr)
			pq.offer(i);
		
		while(!pq.isEmpty())
			System.out.println(pq.poll());
		System.out.println("yes");
		
	}
}
