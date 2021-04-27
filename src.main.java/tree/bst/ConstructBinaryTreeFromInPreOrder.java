package tree.bst;

public class ConstructBinaryTreeFromInPreOrder {

	private static int preIndex = 0;
	public static void main(String[] args) {
		int inOrder[] = {4, 2, 5, 1, 3};  
	    int preOrder[] = {1, 2, 4, 5, 3};
	    int postOrder[] = {4, 5, 2, 3, 1};
	    
	    int length = inOrder.length;
	    
	    Node root = constructBinaryTree(inOrder, preOrder, 0, length-1);
	    
	    printPostOrder(root);
	    
	    int count = checkPostOrderArray(root, postOrder, 0);
	    if(count == postOrder.length) {
	    	System.out.println("Given Preorder, Inorder and Postorder traversals are of same tree");
	    }else {
	    	System.out.println("******NO********");
	    }
	    
	}
	
	private static Node constructBinaryTree(int in[], int pre[], int start, int end) {
		if(start>end)
			return null;
		
//		Pick the current node of preProcessor
		Node treeNode = new Node(pre[preIndex++]);
		
//		If tree has only one node, then return the node
		if(start == end)
			return treeNode;
		
//		If tree has more than one then find out preProcessor node in InOrderProcessor
		int nodeIndex = findNodeIndex(in, treeNode.key);
		
//		Using index in InOrder traversal,  construct left and right subtree
		treeNode.leftNode = constructBinaryTree(in, pre, start, nodeIndex-1);
		treeNode.rightNode = constructBinaryTree(in, pre, nodeIndex+1, end);
		
		return treeNode;
	}
	
	private static int findNodeIndex(int in[], int nodeValue) {
		
		for(int i=0; i<in.length-1; i++) {
			if(in[i] == nodeValue)
				return i;
		}
		return -1;
		
	}
	
	
	private static int checkPostOrderArray(Node root, int postOrder[], int index) {
		if(root == null)
			return index;
		
//		Find left most node
		index = checkPostOrderArray(root.leftNode, postOrder, index);
		
//		Find left most's right node
		index = checkPostOrderArray(root.rightNode, postOrder, index);
//		now check if node value is equal to the postOrder array value
		if(root.key == postOrder[index])
			index++;
		else
			return -1;
		
		return index;
		
	}
	
	private static void printPostOrder(Node root) {
		if(root == null) {
			return;
		}else {
			printPostOrder(root.leftNode);
			printPostOrder(root.rightNode);
			System.out.println(root.key);
		}
	}
}
