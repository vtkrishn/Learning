/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>(){

            public int compare(Interval a,Interval b){
                return a.start - b.start;
            }
        });

        // 0,30
        // 5,10
        // 15,20
        // for(Interval i : intervals)
        //     System.out.println(i.start + "," + i.end);

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>(){
            public int compare(Interval a,Interval b){
                return a.end - b.end;
            }
        });

        pq.offer(intervals[0]);
        //System.out.println(pq.peek().start + "," + pq.peek().end);

        for(int i = 1;i<intervals.length;i++){
            Interval in = pq.poll();
            //System.out.println(intervals[i].start + ">=" + in.end);

            if(intervals[i].start >= in.end){
                //System.out.println("updating end :: "+in.end + " to " + intervals[i].end);
                in.end = intervals[i].end;
            }
            else{
                //System.out.println("offering :: "+intervals[i].start + "," + intervals[i].end);
                pq.offer(intervals[i]);
                //System.out.println("size :: " + pq.size());
            }

            pq.offer(in);
            //System.out.println(pq.peek().start + "," + pq.peek().end);
            //System.out.println("size :: " + pq.size());
        }

        int count = pq.size();

        // 5,20
        // 0,30
        // while(!pq.isEmpty()){
        //     Interval i = pq.poll();
        //     System.out.println(i.start + "," + i.end);
        // }
        return count;
    }
}
