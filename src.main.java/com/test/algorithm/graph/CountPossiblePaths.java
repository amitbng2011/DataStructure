package com.test.algorithm.graph;

import java.util.Iterator;

/**
 * https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
 * 
 * @author amit
 *
 */
public class CountPossiblePaths {

	public static void main(String[] args) {

		Graph g = new Graph(4); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 3); 
        g.addEdge(2, 0); 
        g.addEdge(2, 1); 
        g.addEdge(1, 3); 
		
//		g.addEdge(0, 1); 
//        g.addEdge(1, 2);
//        g.addEdge(2, 10);
//        g.addEdge(10, 11);
//        g.addEdge(11, 12);
//        g.addEdge(12, 3);
//        g.addEdge(2, 3); 
//        g.addEdge(3, 4);
        
        int src = 0, dest = 3; 
		
		CountPossiblePaths countPossiblePaths = new CountPossiblePaths();
		int res = countPossiblePaths.findPath(g, src, dest);
		System.out.println(res);
	}

	private int findPath(Graph graph, int src, int dest) {

		int count = 0;
		boolean[] visited = new boolean[graph.vertex];
		
		int res = findPathUtil(graph, src, dest, visited, count);
		return res;
	}

	private int findPathUtil(Graph graph, int src, int dest, boolean[] visited, int count) {

		visited[src] = true;
		if(src == dest) {
			count++;
		}else {
			Iterator<Integer> itr = graph.adj[src].listIterator();
			while(itr.hasNext()) {
				int node = itr.next();
				if(!visited[node]) {
					count = findPathUtil(graph, node, dest, visited, count);
				}
			}
		}
		
//		Once you get the destination, need to make sure visited as false 
//		else destination node will not get visited again and output will be 1 always
		visited[src] = false; 
		return count;
	}
}
