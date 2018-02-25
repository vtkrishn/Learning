package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {
	
	public static void main(String[] args) {
		List<Integer> it = new ArrayList<Integer>();
		it.add(1);
		it.add(2);
		it.add(3);
		it.add(4);
		
		Stream<Integer> ss = Stream.of(1,2,3,4);
		ss.min((a,b) -> a);
		
	}
}
