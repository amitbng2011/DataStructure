package com.test.algorithm.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * It will find out all the paths between source and destination.
 * Out of collection, Max distance and MIn distance can be fetched
 *
 */
public class FindAllPathsBetweenAirports {

	public static void main(String[] args) {

		Graph1 g = new Graph1("SFO");
		g.addEdge("SFO", "LAX");
		g.addEdge("LAX", "DEN");
		g.addEdge("DEN", "ATL");
		g.addEdge("ATL", "ORD");
		g.addEdge("DEN", "ORD");
		g.addEdge("ORD", "BAL");
        
  
        String src = "LAX";
        String dest = "BAL"; 
		
        FindAllPathsBetweenAirports findAllPathsBetweenAirports = new FindAllPathsBetweenAirports();
        List<List<String>> res = findAllPathsBetweenAirports.findPath(g, src, dest);
        Collections.sort(res, (a, b)-> a.size()-b.size()); // for shortest path
		System.out.println(res.get(0));
	}

	private List<List<String>> findPath(Graph1 graph, String src, String dest) {

		Set<String> visited = new HashSet<String>();
		List<List<String>> ans = new ArrayList<>();
		List<String> path = new ArrayList<>();
		findPathUtil(graph, src, dest, visited, ans, path);
		return ans;
	}

	private void findPathUtil(Graph1 graph, String src, String dest, Set<String> visited,
			List<List<String>> ans, List<String> path) {

		visited.add(src);
		path.add(src);
		if(src == dest) {
			ans.add(new ArrayList<>(path));
		}else {
			Iterator<String> itr = null;
			if(graph.adj.get(src) == null || graph.adj.get(src).isEmpty()) {
				return;
			}
			itr = graph.adj.get(src).listIterator();
			while(itr.hasNext()) {
				String node = itr.next();
				if(!visited.contains(node)){
					findPathUtil(graph, node, dest, visited, ans, path);
					path.remove(path.size()-1);
				}
			}
		}
//		Once you get the destination, need to make sure visited is removed
//		else destination node will not get visited again and output will be 1 always
		visited.remove(src);
	}
}



class Graph1 {

	String vertex;
	Map<String, List<String>> adj;

	Graph1(String vertex){
		this.vertex = vertex;
		adj = new HashMap<>();
	}

	/**
	 * @param src
	 * @param dest
	 */
	public void addEdge(String src, String dest) {
		if(!adj.containsKey(src)) {
			adj.put(src, new ArrayList<String>());
		}
		adj.get(src).add(dest);
	}
}