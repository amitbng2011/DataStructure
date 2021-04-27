package tree.bst;

public class Node {

	int key;
	Node leftNode, rightNode;
	
	public Node(int key) {
		this.key = key;
		this.leftNode = this.rightNode = null;
	}
}
