movingAverage(int size){
LinkedList<Integer> queue = new LinkedList<Integer>();
int sum = 0;
if(queue.size() < size){
	double average = 0;
	for(int i : queue)
		sum += i;
}
else{
	int start = queue.poll();
	int end = queue.poll(newValue);
	sum=sum-start+end;
}
average = sum / queue.size;
return average;
}
