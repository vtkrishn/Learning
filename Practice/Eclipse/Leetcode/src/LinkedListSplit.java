import java.util.ArrayList;
import java.util.List;

public class LinkedListSplit {
	static class Node{
		int data;
		Node next;
		
		public Node(int value) {
			this.data = value;
		}
		
	}
	public static Node createLinkedListNode(int count){
		Node root = null;
		Node dummy = null;
		for(int i=1;i<=count;i++) {
			Node node = new Node(i);
			if(i==1) {
				root = node;
				dummy = root;
			}
			dummy.next = node;
			dummy = dummy.next;
		}
		return root;
	}
	
	/* 			
	 * 1 -> 2 -> 3 -> 4
	 * k = 3
	 * 			[1,2,3] 
	 * 			[4,null, null] 
	 * k = 2
	 * 			[1,2]
	 * 			[3,4]
	 * 			[5,6]	
	 * k = 6 
	 *  		[1,2,3,4,null, null]
	 *  
	 */
	public static List<List<Integer>> splitLinkedList(Node root, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<List<Integer>> result1 = new ArrayList<List<Integer>>();
		Node marker = root;
		for(int i=0;i<k;i++) {
				marker = splitLinkedList(marker, 0, k, new ArrayList<Integer>(), result);
		}
		int mark = 0;
		for(int i=0;i<k;i++) {
			if(result.get(i).get(0) == -1) {
				mark = i;
				break;
			}
			else {
				result1.add(result.get(i));
			}
		}
			
		return result1;
	}
	
	public static Node splitLinkedList(Node node, int index, int k,List<Integer> list,List<List<Integer>> result) {
		if(index == k) {
			result.add(list);
			return node;
		}
		if(list == null)
			list = new ArrayList<Integer>();
		if(node == null) {
				while(index < k) {
					list.add(-1);
					index++;
				}
				result.add(list);
				return node;
			}
			else
				list.add(node.data);
		return splitLinkedList(node.next, index + 1 , k, list,result);
	}
	
	public static void main(String[] args) {
		Node root = createLinkedListNode(4);
		System.out.println("");
		List<List<Integer>> list = splitLinkedList(root, 2);
		for(List<Integer> l : list) {
			System.out.println(l);
		}
	}
	
	
}
