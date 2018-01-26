import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		
		TopKFrequentElements top = new TopKFrequentElements();
		int[] nums = {3,1,1,1,2,2,3,3};
		//System.out.println(top.topKFrequentUsingMapValues(nums, 2));
		System.out.println(top.topKFrequentUsingPriorityQueue(nums, 2));
	}
	public List<Integer> topKFrequentUsingPriorityQueue(int[] nums, int k) {
		Map<Integer, Integer> counterMap = new HashMap<>();
        
        for(int num : nums) {
            int count = counterMap.getOrDefault(num, 0);
            counterMap.put(num, count+1);
        }
        
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Entry<Integer,Integer>>() {
        	@Override
        	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
        		return o2.getValue().compareTo(o1.getValue());
        	}
		});
		for(Map.Entry<Integer, Integer> l : counterMap.entrySet())
			pq.offer(l);
		
		List<Integer> l = new ArrayList<>();
		int count = k;
		while(!pq.isEmpty() && count-- > 0)
			l.add(pq.poll().getKey());
		return l;
		
	}
	public List<Integer> topKFrequentUsingMapValues(int[] nums, int k) {
		Map<Integer,Integer> result = new LinkedHashMap<>();
		Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
        	if(!map.containsKey(nums[i]))
        		map.put(nums[i], 1);
        	else
        		map.put(nums[i], map.get(nums[i]) + 1);
        }
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Entry<Integer,Integer>>() {
        	@Override
        	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
        		return o2.getValue().compareTo(o1.getValue());
        	}
		});
        
        for(Map.Entry<Integer, Integer> lm: list) {
        	result.put(lm.getKey(), lm.getValue());
        }
        
        List<Integer> l = new ArrayList<>();
        int count = k;
        for(Integer i : result.keySet()) {
        	if(count > 0) {
        		l.add(i);
        		count--;
        	}        	
        }
		return l;
    }
}
