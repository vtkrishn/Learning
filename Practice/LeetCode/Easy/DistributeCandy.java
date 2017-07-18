public class Solution {
    public int distributeCandies(int[] candies) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<candies.length;i++){
			int candy = candies[i];
			if(map.containsKey(candy))
				map.put(candy,map.get(candy) + 1);
			else
				map.put(candy,1);
		}
		return map.size() >= candies.length/2 ?  candies.length/2 : map.size();
    }
}
