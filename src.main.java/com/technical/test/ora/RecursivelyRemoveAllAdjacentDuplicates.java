package com.technical.test.ora;

import java.util.Stack;

public class RecursivelyRemoveAllAdjacentDuplicates {

	public static void main(String[] args) {
		
		String str = "azxxxzy";
		RecursivelyRemoveAllAdjacentDuplicates obj = new RecursivelyRemoveAllAdjacentDuplicates();
		String ans = obj.removeDuplicates(str);
		System.out.println(ans);
	}
	
	public String removeDuplicates(String str) {
		
		Stack<Character> stack = new Stack<>();
		char[] arr = str.toCharArray();
		char lastRemoved = '$';
		for(char c : arr) {
			
			if(lastRemoved == c)
				continue;
			if(!stack.isEmpty() && stack.peek() == c) {
				lastRemoved = stack.peek();
				stack.pop();
			}else {
				stack.push(c);
				lastRemoved = '$';
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		return sb.reverse().toString();
	}
}
