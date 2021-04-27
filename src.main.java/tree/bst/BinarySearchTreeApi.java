package tree.bst;

public class BinarySearchTreeApi {

	Node root;
	
	void insertNode(int key){
		root = insertNode(root, key);
	}
	
	private Node insertNode(Node node, int key) {
		if(node == null) 
			return new Node(key);
		
		if(key<node.key)
			node.leftNode = insertNode(node.leftNode, key);
		if(key>node.key)
			node.rightNode = insertNode(node.rightNode, key);
		
		return node;
	}
	
	
	
	/**
	 * Find min value in the bSt
	 * @param node
	 * @return
	 */
	public int findMinValue(Node node) {
		int minValue = node.key;
		
		while(node.leftNode != null) {
			minValue = node.leftNode.key;
			node = node.leftNode;
		}
		return minValue;
	}
	
	public int findMaxValue(Node node) {
		int maxValue = node.key;
		while(node.rightNode != null) {
			maxValue = node.rightNode.key;
			node = node.rightNode;
		}
		return maxValue;
	}
	
	void inOrderTraverse(){
		inOrderTraversal(root);
	}
	void preOrderTraverse(){
		inOrderTraversal(root);
	}
	void postOrderTraverse(){
		inOrderTraversal(root);
	}
	
	public void inOrderTraversal(Node root) {
		if(root == null) {
			return;
		}else {
			inOrderTraversal(root.leftNode);
			System.out.println(root.key);
			inOrderTraversal(root.rightNode);
		}
	}
	
	void preOrderTRaversal(Node root) {
		if(root == null) {
			return;
		}else {
			System.out.println(root.key);
			preOrderTRaversal(root.leftNode);
			preOrderTRaversal(root.rightNode);
		}
	}
	
	void postOrderTraversal(Node root) {
		if(root == null) {
			return;
		}else {
			postOrderTraversal(root.leftNode);
			postOrderTraversal(root.rightNode);
			System.out.println(root.key);
		}
			
		
	}
}
