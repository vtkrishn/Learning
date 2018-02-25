package com.thread;

public class Main {
	
	public static void main(String[] args) {
		
		long start = 0;
		long end = 0;
		
		start = System.currentTimeMillis();
		for(int i=1;i<=100000000;i++) {
		}
		end = System.currentTimeMillis();
		System.out.println("Time taken by for loop to print 1 to 10000 :: "+ (end-start) + " ms");
		
		
		Worker worker = new Worker();
		Thread thread1 = new Thread(worker);
		Thread thread2 = new Thread(worker);
		start = System.currentTimeMillis();
		thread1.start();
		thread2.start();
		end = System.currentTimeMillis();
		try {
			thread1.join();
			thread2.join();
			System.out.println("Time taken by for loop to print 1 to 10000 :: "+ (end-start) + " ms");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	static class Worker implements Runnable{
		int value = 0;
		@Override
		public void run() {
			
			while(value < 100000000) {
				print();
			}
		}
		
		
		private void print() {
			synchronized(this) {
				value++;
			}
		}
	}
	
}
