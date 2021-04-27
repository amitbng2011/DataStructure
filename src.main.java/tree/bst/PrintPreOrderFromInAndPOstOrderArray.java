package tree.bst;

public class PrintPreOrderFromInAndPOstOrderArray {

	private static int postIndex = 0;
	public static void main(String[] args) {
	
		int in[] = { 9,3,15,20,7}; 
		int post[] = {9,15,7,20,3};
		
		int length = in.length-1;
		postIndex = length;
		Node root = constructPreOrder(in, post, 0, length);
		printPreOrder(root);
		
	}
	
	private static Node constructPreOrder(int in[], int post[], int start, int end) {
		
		if(start>end)
			return null;
		Node root = new Node(post[postIndex--]);
		if(start == end)
			return root;
		
		int inIndex = findElement(root, in, end);
		
		root.rightNode = constructPreOrder(in, post, inIndex+1, end);
		root.leftNode = constructPreOrder(in, post, start, inIndex-1);
	
		
		return root;
		
		
	}
	
	private static int findElement(Node node, int in[], int end) {
		
		if(node == null)
			return -1;
		for(int i=0; i<end;i++) {
			if(in[i] == node.key)
				return i;
		}
		return -1;
		
	}
	
	
	private static void printPreOrder(Node node) {
		
		if(node == null) {
			return;
		}else {
			System.out.println(node.key);
			printPreOrder(node.leftNode);
			printPreOrder(node.rightNode);
		}
	}

}
