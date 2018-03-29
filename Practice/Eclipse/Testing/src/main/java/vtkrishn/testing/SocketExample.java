package vtkrishn.testing;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class SocketExample {

	public static void main(String[] args) {
		SocketChannel socket = null;
		try {
			socket = SocketChannel.open();
			socket.connect(new InetSocketAddress("http://127.0.0.1", 8080));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
