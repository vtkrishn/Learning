package vtkrishn.testing;

public class Test {
	private static void print(long value) {
			//System.out.println(value);
	}
public static void main(String[] args) {
		
		long start = 0;
		long end = 0;
		
		start = System.currentTimeMillis();
		long value = 0;
		while(value < 1000000000l) {
			print(value++);
		}
		end = System.currentTimeMillis();
		System.out.println("Time taken by while loop :: "+ (end-start) + " ms");
		
		
		Worker worker = new Worker();
		Thread thread1 = new Thread(worker);
		Thread thread2 = new Thread(worker);
		start = System.currentTimeMillis();
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
			end = System.currentTimeMillis();
			System.out.println("Time taken by threads :: "+ (end-start) + " ms");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	static class Worker implements Runnable{
		long value = 0;
		public void run() {
			
			while(value < 100000000l) {
				print();
			}
		}
		
		
		private void print() {
			synchronized(this) {
				//System.out.println(value);
				value++;
			}
		}
	}
}
