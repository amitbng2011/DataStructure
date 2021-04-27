package com.technical.test.c;

import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 *
 */
public class RopesWithMinCost {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 6 };
		RopesWithMinCost obj = new RopesWithMinCost();
		int res = obj.minCost(arr);
		System.out.println(res);
	}
	
	public int minCost(int[] arr) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<arr.length; i++) {
			pq.add(arr[i]);
		}
		
		int sum = 0;
		
		while(pq.size()>1) {
			int first = pq.poll();
			int second = pq.poll();
			
			sum = first+second;
			pq.add(sum);
		}
		return sum;
	}
}
