package com.technical.test.ver;

public class MaxSubArraySumOfSizeK {

	public static void main(String[] args) {
		
		int[] arr = new int[] {100, 60, 300, 200};
		MaxSubArraySumOfSizeK obj = new MaxSubArraySumOfSizeK();
		System.out.println(obj.getMaxSum(arr, 2));
	} 
	
	public int getMaxSum(int[] arr, int k) {
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<=arr.length-k; i++) {
			int j=i;
			int sum = 0;
			while(j<i+k) {
				sum += arr[j++];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
	
}
