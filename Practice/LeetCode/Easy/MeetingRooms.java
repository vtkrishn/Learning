public class Solution {

    class Interval{
      int start;
      int end;
    }

      public boolean canAttendAllMeetings(Interval[] time){
          Arrays.sort(time, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
              return a.start-b.start;
            }
          });
          for(int i=0;i<time.length;i++){
            if(time[i].end > time[i+1].start)
              return false;
          }
          return true;
      }
}
