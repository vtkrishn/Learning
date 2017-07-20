public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length,Collections.reverseOrder());
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		String[] result = new String[nums.length];

		for(int i=0;i<nums.length;i++){
			pq.add(nums[i]);
		}

		for(int i=0;i<nums.length;i++){
			map.put(pq.poll(),i+1);
		}
		for(int i=0;i<nums.length;i++){
			int val = map.get(nums[i]);
			if(val == 1)
				result[i] = "Gold Medal";
			else if(val == 2)
				result[i] = "Silver Medal";
			else if(val == 3)
				result[i] = "Bronze Medal";
			else
				result[i]=""+val;

		}
		return result;
    }
}
