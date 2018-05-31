package vtkrishn.testing;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

	int size;
	Map<Integer, Node> nodeMap;
	Map<Integer, DLL> frequencyMap;

	public LFUCache(int capacity) {
		this.size = capacity;
		this.nodeMap = new HashMap<Integer, Node>();
	}

	class Node{
		int val;
		int freq;
		Node next;
		Node prev;
		public Node(int value) {
			this.val = value;
			this.freq = 1;
			this.next = null;
			this.prev = null;
		}

		public void updateFrequency() {
			this.freq++;
		}
	}

	class DLL{
		Node head;
		Node tail;
		int size;

		public DLL() {
			this.head = new Node(0);
			this.tail = new Node(0);
		}

		public void addNode(Node node) {
			node.next = head;
			head.prev = node;
			head = node;
			this.size++;
		}

		public void removeNode(Node node) {
			Node prev = node.prev;
			Node next = node.next;
			prev.next = next;
			next.prev = prev;
			node.next = null;
			node.prev = null;
			this.size--;
		}
	}



	public void put(int key, int value) {
		if(size == 0)
			return;

		if(!nodeMap.containsKey(key)) {

			if(nodeMap.size() < size) {
				Node newNode = new Node(value);
				nodeMap.put(key, newNode);
				DLL dll = frequencyMap.get(newNode.freq);
				if(dll == null) {
					dll = new DLL();
				}
				else {
					dll.removeNode(newNode);
				}


			}
			else {

			}

		}
		else {
			Node node = nodeMap.get(key);
			node.val = value;
			DLL dll = frequencyMap.get(node.freq);
			dll.removeNode(node);
			//if(node.freq == 1 && dll.size == 0)
		}


	}


	public int get(int key) {
		if(!nodeMap.containsKey(key))
			return - 1;
		Node node = nodeMap.get(key);

		//insert into correct frequency map
		DLL dll = frequencyMap.get(node.freq);
		if(dll == null)
			dll = new DLL();

		dll.removeNode(node);
		if(dll.size == 0)


		node.updateFrequency();
		dll.addNode(node);
		frequencyMap.put(node.freq, dll);
		return node.val;
	}

	public static void main(String[] args) {
		LFUCache cache = new LFUCache( 2 );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.get(3);       // returns 3.
		cache.put(4, 4);    // evicts key 1.
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
	}





}
