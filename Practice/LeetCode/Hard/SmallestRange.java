class Solution {
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
