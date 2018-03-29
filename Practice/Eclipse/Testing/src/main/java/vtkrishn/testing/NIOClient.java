package vtkrishn.testing;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {

	public static void main(String[] args) throws IOException {
		InetSocketAddress addr = new InetSocketAddress("localhost", 1111);
		SocketChannel socket = SocketChannel.open(addr);
		socket.configureBlocking(false);
		
		socket.write(ByteBuffer.wrap("vinod".getBytes()));
	
	}
}