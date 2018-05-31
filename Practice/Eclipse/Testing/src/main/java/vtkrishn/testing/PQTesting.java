package vtkrishn.testing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PQTesting {

		static class Node{
			int val;
			int key;
			public Node(int key, int data) {
				this.val = data;
				this.key = key;
			}
		}
		
		static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		public static void main(String[] args) {
			Comparator<Map.Entry<Integer,Integer>> comp  = new Comparator<Map.Entry<Integer,Integer>>() {

				public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
					return o2.getValue()-o1.getValue();
				}
				
				
			};
			PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>(comp);
			
			int[] nums = {1,1,2,2,3,2,2,3,3};
			for(int n : nums)
				map.put(n, map.getOrDefault(n, 0)+1);
			
			for(Map.Entry<Integer, Integer> entry : map.entrySet())
				pq.offer(entry);
			
			while(!pq.isEmpty()) {
				System.out.println(pq.poll().getKey());
			}
		}
}
