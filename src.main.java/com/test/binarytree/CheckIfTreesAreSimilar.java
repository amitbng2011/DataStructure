package com.test.binarytree;

public class CheckIfTreesAreSimilar {

	static Node root1;
	static Node root2;
	
	public static void main(String[] args) {
		root1 = new Node(1); 
		root1.left = new Node(2); 
		root1.right = new Node(3); 
        root1.left.left = new Node(4); 
        root1.left.right = new Node(5); 
   
        root2 = new Node(1); 
        root2.left = new Node(2); 
        root2.right = new Node(3); 
        root2.left.left = new Node(4); 
        root2.left.right = new Node(5); 
        System.out.println(checkSimilarTrees(root1, root2));
	}
	
	public static boolean checkSimilarTrees(Node root1, Node root2) {
		
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 != null && root2 != null) {
			return root1.data == root2.data 
					&& checkSimilarTrees(root1.left, root2.left)
					&& checkSimilarTrees(root1.right, root2.right);
		}
		return false;
	}
}
