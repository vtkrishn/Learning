public class YourClassNameHere {
	    public static void main(String[] args) {
	java.util.List<Interval> l = new java.util.ArrayList<Interval>();
l.add(new Interval(1,3));
l.add(new Interval(2,5));
l.add(new Interval(6,8));
l.add(new Interval(7,10));
l.add(new Interval(12,15));
l.add(new Interval(13,14));
overlap(l);
	    }

	static void overlap(java.util.List<Interval> intervals){
	if(intervals == null)
		return;
    int currentSum = 0;
    int minStart = 0;
    int maxEnd = 0;
    int max = 0;
    java.util.Iterator it = intervals.iterator();
	while(it.hasNext()){
		Interval i = (Interval)it.next();

		if(i.startTime < maxEnd){
		  currentSum = 0;
		}
		else{
		  max = max + currentSum;
	  }

		if(i.startTime > minStart && i.startTime > maxEnd){
		  minStart = i.startTime;
		}

		if(i.endTime > maxEnd){
			maxEnd = i.endTime;
		}

      currentSum = currentSum + Math.abs(minStart - maxEnd);

    }
    max = max + currentSum;

}



 static class Interval{
	int startTime;
	int endTime;

	Interval(int start,int end){
		this.startTime  = start;
		this.endTime  = end;
	}

}

}
