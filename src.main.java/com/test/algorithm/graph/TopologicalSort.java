package com.test.algorithm.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://geeksforgeeks.org/topological-sorting/
 * 
 * @author amit
 *
 */
public class TopologicalSort {

	int v;
	ArrayList<ArrayList<Integer>> vertex;
	
	public TopologicalSort(int size) {
		this.v = size;
		vertex = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<v; i++) {
			vertex.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int u, int v) {
		vertex.get(u).add(v);
	}
	
	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(5, 2);  
        g.addEdge(5, 0);  
        g.addEdge(4, 0);  
        g.addEdge(4, 1);  
        g.addEdge(2, 3);  
        g.addEdge(3, 1); 
        g.topoSort();
	}
	
	
	public void topoSort() {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		
		for(int i=0; i<vertex.size(); i++) {
			if(!visited.contains(v)) {
				recurTopoSort(stack, visited, i);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}
	
	public void recurTopoSort(Stack<Integer> stack, Set<Integer> visited, int v) {
		
		visited.add(v);
		
		ArrayList<Integer> list = vertex.get(v);
		
		for(int node : list) {
			if(!visited.contains(node)) {
				recurTopoSort(stack, visited, node);
			}
		}
		
		stack.push(v);
	}
}
