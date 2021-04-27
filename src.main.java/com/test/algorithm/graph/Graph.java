package com.test.algorithm.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 * https://www.geeksforgeeks.org/iterative-depth-first-traversal/
 * 
 * @author amit
 *
 */
public class Graph {

	int vertex;
	LinkedList<Integer> adj[];

	Graph(int vertex){
		this.vertex = vertex;
		adj = new LinkedList[vertex];

		for(int i=0; i<vertex; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	/**
	 * @param src
	 * @param dest
	 */
	public void addEdge(int src, int dest) {
		adj[src].add(dest);
//		adj[dest].add(src);
	}

	/**
	 * @param start
	 */
	public void printGraph(int start) {
		printBFS(start);
		System.out.println();
		printDFS_Iterative(start);
		
		System.out.println();
		
		boolean[] visited = new boolean[vertex];
		printDFS_Recursive(start, visited);
	}


	/**
	 * @param start
	 */
	private void printBFS(int start) {

		boolean[] visited = new boolean[vertex];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;

		while(queue.size() != 0) {

			int node = queue.poll();
			System.out.print(node+" ");

			Iterator<Integer> itr = adj[node].listIterator();

			while(itr.hasNext()) {

				node = itr.next();
				if(!visited[node]) {
					visited[node] = true;
					queue.add(node);
				}

			}
		}
	}
	
	
	/**
	 * @param start
	 */
	private void printDFS_Iterative(int start) {
		
		boolean[] visited = new boolean[vertex];
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while(stack.isEmpty() == false) {
			
			int top = stack.pop();
			
			if(!visited[top]) {
				visited[top] = true;
				System.out.print(top+" ");
			}
			
			Iterator<Integer> itr = adj[top].listIterator();
			
			while(itr.hasNext()) {
				int next = itr.next();
				if(!visited[next]) {
					stack.push(next);
				}
			}
			
		}
		
	}
	
	/**
	 * @param start
	 * @param visited
	 */
	private void printDFS_Recursive(int start, boolean[] visited) {
		
		visited[start] = true;
		System.out.print(start+" ");
		Iterator<Integer> itr = adj[start].listIterator();
		while(itr.hasNext()) {
			int next = itr.next();
			if(!visited[next]) {
				printDFS_Recursive(next, visited);
			}
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 

		System.out.println("Following is Breadth First Traversal "+ 
				"(starting from vertex 2)"); 

		g.printGraph(2); 
	}
}
