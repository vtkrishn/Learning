package vtkrishn.testing;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {


	Map<Integer, Node> map = new HashMap<Integer, Node>();
	class Node{
		int data;
		Node parent;
		int rank;

		public Node(int data) {
			this.data = data;
		}
	}
	public void makeSet(int data) {
		Node node = new Node(data);
		node.rank = 0;
		node.parent = node;
		map.put(data, node);
	}

	public void union(int a, int b) {
		Node parent1 = find(map.get(a));
		Node parent2 = find(map.get(b));

		if(parent1.data == parent2.data)
			return;

		if(parent1.rank > parent2.rank)
			parent2.parent = parent1;
		else if(parent1.rank == parent2.rank) {
			parent1.rank++;
			parent2.parent = parent1;
		}
		else {
			parent1.parent = parent2;
		}
	}


	public Node find(Node node) {
		Node parent = node.parent;
		if(parent == node)
			return node;
		return find(parent);
	}

	public Node find(int data) {
		return find(map.get(data));
	}

	public static void main(String[] args) {
		DisjointSet d = new DisjointSet();
		d.makeSet(1);
		d.makeSet(2);
		d.makeSet(3);
		d.makeSet(4);

		d.union(1, 3);
		d.union(2, 3);

		for(int i=1;i<=4;i++) {
			Node n = d.find(i);
			System.out.println(n.data);
		}

	}
}
