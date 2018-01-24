import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {

	public static void main(String[] args) {
		SmallestRange small = new SmallestRange();
		Integer[] a = {4,10,15,24,26};
		Integer[] b = {0,9,12,20};
		Integer[] c = {5,18,22,30};
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Arrays.asList(a));
		list.add(Arrays.asList(b));
		list.add(Arrays.asList(c));
		small.smallestRange(list);
	}
	
	class Element{
		int row;
		int col;
		int val;
		
		public Element(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
	public int[] smallestRange(List<List<Integer>> nums) {
	    PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {

			@Override
			public int compare(Element o1, Element o2) {
				return o1.val - o2.val;
			}
	    	
		});
	    
	    int max = Integer.MIN_VALUE;
		for(int i=0;i<nums.size();i++) {
				int val = nums.get(i).get(0);
	    		pq.offer(new Element(i, 0, val));
	    		max  = Math.max(max, val);
	    }
		
		int left = -1;
		int right = -1;
		int range = Integer.MAX_VALUE;
		while(pq.size() == nums.size()) {
			Element current = pq.poll();
			if((max - current.val) < range) {
				range = max-current.val;
				left = current.val;
				right = max;
			}
			
			if(current.col < nums.get(current.row).size()-1) {
				current.col++;
				current.val = nums.get(current.row).get(current.col);
				pq.offer(current);
			}
			
			max = Math.max(max, nums.get(current.row).get(current.col));
			
		}
		
		return new int[] {left, right};
	}
	
}
