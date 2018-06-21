package vtkrishn.testing;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

class NumberIslands {
    
	static Queue<Integer> q = new LinkedList<Integer>();
	static int RATE_LIMIT= 5;
	public static void main(String[] args) {
		q.offer(1);
		int count = 2;
		while(q.peek() < 10) {
			Integer start = q.peek();
			if((count - start) < RATE_LIMIT) {
				System.out.println("Accepting inputs :: "+ count);
				q.offer(count++);
			}
			else {
				System.out.println("Kicking off :: "+ q.poll());
			}
		}
		
	}
}