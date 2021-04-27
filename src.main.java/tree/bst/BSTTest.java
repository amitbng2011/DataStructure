package tree.bst;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTreeApi binarySearchTree = new BinarySearchTreeApi();
		binarySearchTree.insertNode(20);
		binarySearchTree.insertNode(15);
		binarySearchTree.insertNode(16);
		binarySearchTree.insertNode(25);
		binarySearchTree.insertNode(30);
		
		binarySearchTree.inOrderTraverse();
		binarySearchTree.preOrderTraverse();
		binarySearchTree.postOrderTraverse();
	}
}
