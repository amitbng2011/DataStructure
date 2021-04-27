package com.test.algorithm.search;

public class FindElementInSortedRotatedArray {

	public static void main(String[] args) {
		int [] arr = {6,8,9,10,16,3};
		int key = 7;
		
		System.out.println(findElement(arr, key));
	}
	
	private static int findElement(int[] arr, int key) {
		int pivot = getPivot(arr);
		if(pivot == -1)
			binarySerch(arr, 0, arr.length-1, key);
		
		if(arr[pivot] == key)
			return pivot;
		
		if(arr[0]<=key)
			binarySerch(arr, 0, pivot-1, key);
		binarySerch(arr, pivot+1, arr.length, key);
		return 0;
	}
	
	private static int getPivot(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			if(arr[i]>arr[i-1]) {
				continue;
			}else {
				return arr[i];
			}
		}
		return -1;
	}
	
	private static void binarySerch(int[] arr, int low, int high, int key) {
		
	}
}
