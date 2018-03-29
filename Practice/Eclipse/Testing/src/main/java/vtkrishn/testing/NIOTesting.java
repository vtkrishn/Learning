package vtkrishn.testing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTesting {
	
	
	public static void main(String[] args) {
		
		try {
			//Reference to the file
			RandomAccessFile rand = new RandomAccessFile("D:\\CXSFA_Sprint 2 Updates.txt", "rw");
			
			//Create a channel
			FileChannel channel = rand.getChannel();
			
			//Create a buffer of length 2, at a time 2 characters 
			//will be read from the file and added to the buffer
			ByteBuffer buf = ByteBuffer.allocate(2);
			
			//read the bytes into the buffer
			//int byteReads = channel.read(buf);
			
			buf.put((byte) 48);
			buf.flip();
			while(buf.hasRemaining())
				System.out.println((char)buf.get()); 
			
			//if bytereads are available
//			while(byteReads != -1) {
//				
//				//go to the start of the buffer
//				buf.flip();
//				
//				while(buf.hasRemaining())
//					System.out.println((char)buf.get()); // read from the current position and increment the current position
//				
//				//clear the buffer and make it available for writing again, position will be set to 0
//				buf.clear();
//				
//				//again read in to the buffer
//				byteReads = channel.read(buf);
//			}
			
			//close the file
			rand.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
