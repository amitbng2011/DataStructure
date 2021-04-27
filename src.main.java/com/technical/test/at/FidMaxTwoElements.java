package com.technical.test.at;

import java.util.Arrays;
import java.util.List;

public class FidMaxTwoElements {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(23,1,78,43,98,34,10,34);
		FidMaxTwoElements obj = new FidMaxTwoElements();
		obj.findMaxTwo(list);
	}
	
	public void findMaxTwo(List<Integer> list) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)>max1) {
				max2 = max1;
				max1 = list.get(i);
			}
			else if(list.get(i)>max2) {
				max2 = list.get(i);
			}
		}
		System.out.println("first amx "+max1+" secons max "+max2);
	}
}
