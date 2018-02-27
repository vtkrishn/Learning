package com.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CloneGraph {
	
	static class UndirectedGraph{
		int label;
		List<UndirectedGraph> neightbors;
		
		public UndirectedGraph(int x) {
			this.label = x;
			this.neightbors = new ArrayList<UndirectedGraph>();
		}
	}
	
	public static void main(String[] args) {
		UndirectedGraph zero = new UndirectedGraph(0);
		UndirectedGraph one = new UndirectedGraph(1);
		UndirectedGraph two = new UndirectedGraph(2);
		
		zero.neightbors.add(one);
		zero.neightbors.add(two);
		
		one.neightbors.add(two);
		
		two.neightbors.add(two);
		
		//DFS iterative
		//cloneDFSIterative(zero);
		
		//DFS recursive
		//Map<UndirectedGraph,UndirectedGraph> map = new HashMap<UndirectedGraph,UndirectedGraph>();
		//cloneDFSRecursive(zero,map);
		
		//BFS
		cloneBFS(zero);
	}
	
	
	private static UndirectedGraph cloneBFS(UndirectedGraph root) {
		if(root == null)
			return null;
		
		Queue<UndirectedGraph> queue = new LinkedList<UndirectedGraph>();
		Map<UndirectedGraph,UndirectedGraph> map = new HashMap<UndirectedGraph,UndirectedGraph>();
		queue.offer(root);
		map.put(root, new UndirectedGraph(root.label));
		
		while(!queue.isEmpty()) {
			UndirectedGraph node = queue.poll();
			
			for(UndirectedGraph n : node.neightbors) {
				if(!map.containsKey(n)) {
					map.put(n, new UndirectedGraph(n.label));
					queue.offer(n);
				}
				map.get(node).neightbors.add(map.get(n));
			}
		}
		
		return map.get(root);
	}
	
	private static UndirectedGraph cloneDFSRecursive(UndirectedGraph root,Map<UndirectedGraph,UndirectedGraph> map) {
		if(root == null)
			return null;
		
		UndirectedGraph clone = new UndirectedGraph(root.label);
		map.put(root, clone);
		
		for(UndirectedGraph child : root.neightbors) {
			if(map.containsKey(child))
				clone.neightbors.add(map.get(child));
			else
				clone.neightbors.add(cloneDFSRecursive(child,map));
		}
		
		return clone;
	}
	
	private static UndirectedGraph cloneDFSIterative(UndirectedGraph root) {
		if(root == null)
            return null;
		
		 
		
		Stack<UndirectedGraph> stack = new Stack<UndirectedGraph>();
		Map<UndirectedGraph,UndirectedGraph> map = new HashMap<UndirectedGraph,UndirectedGraph>();
		
		//add to the map
		map.put(root, new UndirectedGraph(root.label));
		//push it to the stack
		stack.push(root);
		
		//iterate the stack
		while(!stack.isEmpty()) {
			//get from the stack
			UndirectedGraph child = stack.pop();
			
			//iterate for the neighbors
			for(UndirectedGraph neighbor : child.neightbors) {
				//if map is not defined then add to the map
				if(!map.containsKey(neighbor)) {
					map.put(neighbor, new UndirectedGraph(neighbor.label));
					stack.push(neighbor);
				}
				//get from the maps neighbor and add to the clone's neighbors
				map.get(child).neightbors.add(map.get(neighbor));
			}
		}
		
		//return from the map
		return map.get(root);
	}
	
	
}
