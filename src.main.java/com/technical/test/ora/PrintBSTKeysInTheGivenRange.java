package com.technical.test.ora;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/
 * 
 * Time Complexity: O(n), where n is the total number of keys in tree.
		A single traversal of the tree is needed.
		Space Complexity: O(1).
		No extra space is required.
 *
 */
public class PrintBSTKeysInTheGivenRange {

	static int sum = 0;
	public static void main(String[] args) {
		PrintBSTKeysInTheGivenRange obj = new PrintBSTKeysInTheGivenRange();

		int low = 10, high = 25; 
		Node root = new Node(20); 
		root.left = new Node(8); 
		root.right = new Node(22); 
		root.left.left = new Node(4); 
		root.left.right = new Node(12); 

		List<Integer> list = new ArrayList<>();
		obj.getRangeNums(root, low, high, list);

		for(int i : list)
			System.out.println(i);
		
		obj.getRangeSum(root, low, high);
		System.out.println(sum);
	}

	public void getRangeNums(Node root, int low, int high, List<Integer> list){

		if(root==null)
			return;

		if(low<root.data) // expand left side
			getRangeNums(root.left, low, high, list);

		if(low<=root.data && root.data<=high) // print the element
			list.add(root.data);

		if(root.data<high) // expand right side
			getRangeNums(root.right, low, high, list);
	}

	public void getRangeSum(Node root, int low, int high){

		if(root==null)
			return;

		if(low<root.data) // expand left side
			getRangeSum(root.left, low, high);

		if(low<=root.data && root.data<=high) // print the element
			sum = sum + root.data;

		if(root.data<high) // expand right side
			getRangeSum(root.right, low, high);
	}
}

class Node{
	int data;
	Node left;
	Node right;

	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}