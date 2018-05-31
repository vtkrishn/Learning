class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        Comparator<Map.Entry<Character, Integer>> comp = new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b){
                return b.getValue() - a.getValue();
            }
        };
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(comp);

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            int i= 0;
            while(i++<entry.getValue())
                sb.append(entry.getKey());
        }
        return sb.toString();
    }
}
