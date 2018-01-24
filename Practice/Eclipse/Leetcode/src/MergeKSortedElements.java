import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedElements {

	static class ListNode{
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		MergeKSortedElements m = new MergeKSortedElements();
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(7);
		ListNode l3 = new ListNode(12);
		ListNode l4 = new ListNode(23);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ListNode m1 = new ListNode(-1);
		ListNode m2 = new ListNode(11);
		ListNode m3 = new ListNode(15);
		ListNode m4 = new ListNode(21);
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(13);
		ListNode n4 = new ListNode(20);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ListNode[] list = {l1, m1,n1};
		m.mergeKList(list);
		
	}
	
	
	public ListNode mergeKList(ListNode[] list){
		
//		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(list.length, new Comparator<ListNode>() {
//			
//			@Override
//			public int compare(ListNode o1, ListNode o2) {
//				if(o1.val == o2.val)
//					return 0;
//				else if(o1.val > o2.val)
//					return 1;
//				return -1;
//			}
//		});
//		
//		List<ListNode> result = new ArrayList<ListNode>();
//		for(int i=0;i<list.length;i++) {
//			pq.offer(list[i]);
//		}
//		
//		while(pq.size() == list.length) {
//			ListNode item = pq.poll();
//			result.add(item);
//			if(item.next != null)
//				pq.offer(item.next);
//		}
//		
//		for(ListNode item : result)
//			System.out.println(item.val);
//		return result;
		
PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(list.length, new Comparator<ListNode>() {
			
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val == o2.val)
					return 0;
				else if(o1.val > o2.val)
					return 1;
				return -1;
			}
		});
		
        ListNode dummy = new ListNode(0);
		ListNode head = dummy; 
        for(int i=0;i<list.length;i++) {
			pq.offer(list[i]);
		}
		
		while(pq.size() == list.length) {
			ListNode item = pq.poll();
			dummy.next = item;
			if(item.next != null)
				pq.offer(item.next);
			dummy = dummy.next;
		}
		
		return head.next;
	}
	
}
