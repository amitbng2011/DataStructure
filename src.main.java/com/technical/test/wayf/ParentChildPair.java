package com.technical.test.wayf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4   15
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7    11


Sample input/output (pseudodata):

parentChildPairs = [
    (1, 3), (2, 3), (3, 6), (5, 6), (15, 9),
    (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
]


Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.


Output may be in any order:

findNodesWithZeroAndOneParents(parentChildPairs) => [
  [1, 2, 4, 15],       // Individuals with zero parents
  [5, 7, 8, 11]        // Individuals with exactly one parent
]

n: number of pairs in the input


Solution: Key to solving this question is to come up with a (N+1) x N matrix. 
N is the number of nodes. An extra row is to store the sum of the column. 
The column of this matrix represents the child node and row represents parent nodes. 
For each input pair value, you can mark 1 at relevant position in a matrix. 
For example, [1, 3]  suggest matrix[1][3] =1. So, each 1 in the matrix represents parent to child 
connection. Once you form this. It is very easy to derive the parent count. Each column sum is the 
total number of parents pointing to that child.

Time Complexity: O( n * n )

 */
public class ParentChildPair {

	public static void main(String[] args) {
		int[][] parentChildPairs = new int[][] {
			{1, 3}, {2, 3}, {3, 6}, {5, 6}, {15, 9}, {5, 7}, 
			{4, 5}, {4, 8}, {4, 9}, {9, 11}
		};
		
		/*
        1   2   4
         \ / \ / \
          3   5   8
           \ / \   \
            6   7   9
       */
		
		List<Node> nodeList = new ArrayList<Node>();
        nodeList.add(new Node(-1, 1));
        nodeList.add(new Node(-1, 2));
        nodeList.add(new Node(-1, 4));
        nodeList.add(new Node(1, 3));
        nodeList.add(new Node(2, 3));
        nodeList.add(new Node(2, 5));
        nodeList.add(new Node(4, 5));
        nodeList.add(new Node(4, 8));
        nodeList.add(new Node(3, 6));
        nodeList.add(new Node(5, 6));
        nodeList.add(new Node(5, 7));
        nodeList.add(new Node(8, 9));

		ParentChildPair obj = new ParentChildPair();
		List<List<Integer>> ans = obj.printNodesByParent(nodeList);
		System.out.println(ans);
	}

	public List<List<Integer>> printNodesByParent(List<Node> nodeList){
		Map<Integer, Integer> nodeIndexMap = scanNodes(nodeList);
		Map<Integer, Integer> indexNodeMap = inverseMap(nodeIndexMap);

		int[][] graph = new int[nodeIndexMap.size()+1][nodeIndexMap.size()+1];

//		Assign 1 to each inbound location in the 2 d array
		for(Node node : nodeList){
			if(node.getParent() != -1){
				graph[nodeIndexMap.get(node.getParent())][nodeIndexMap.get(node.getValue())] = 1;
			}
		}

//		Now add all the inbound array for a particular row and see what is the count
		for(int j = 0; j < graph[0].length - 1; j++){
			int sum = 0;
			for(int i = 0; i < graph.length - 1; i ++){
				sum += graph[i][j];
			}
			graph[graph.length - 1][j] = sum;
		}

//		Based on total inbound count, you can make the list of nodes
		
		List<Integer> zeroList = new ArrayList<>();
		List<Integer> oneList = new ArrayList<>();
		for(int i = graph.length - 1, j = 1; j < graph[0].length - 1 ; j++){
			if(graph[i][j] == 0){
				zeroList.add(indexNodeMap.get(j));
			}
			if(graph[i][j] == 1)
				oneList.add(indexNodeMap.get(j));
		}
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(zeroList);
		ans.add(oneList);
		return ans;
	}

	/**
	 * Make index as key and value as value in the map now
	 */
	public static Map<Integer, Integer> inverseMap(Map<Integer, Integer> inputMap){
		Map<Integer, Integer> indexNodeMap = new HashMap<Integer, Integer>();
		for(Map.Entry<Integer, Integer> entry : inputMap.entrySet()){
			indexNodeMap.put(entry.getValue(), entry.getKey());
		}
		return indexNodeMap;
	}

	/**
	 * Map will contain value and its index. Reason because there could be scenario where node 
	 * value is greater that length of the array
	 */
	public static Map<Integer, Integer> scanNodes(List<Node> nodeList){
		Map<Integer, Integer> nodeIndexMap = new HashMap<Integer, Integer>();
		nodeIndexMap.put(-1, 0);
		int index = 1;
		for(Node node: nodeList){
			if(!nodeIndexMap.containsKey(node.getValue())){
				nodeIndexMap.put(node.getValue(), index);
				index++;
			}
		}
		return nodeIndexMap;
	}

}

class Node {
    
    int parent = -1; // parent value with -1 is root
    int value = 0;
    
    public Node(int parent, int value){
        this.parent = parent;
        this.value = value;
    }
    
    public int getParent(){
        return parent;
    }
    
    public int getValue(){
        return value;
    }
}
