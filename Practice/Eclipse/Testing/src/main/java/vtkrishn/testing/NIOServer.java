package vtkrishn.testing;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {

	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		ServerSocketChannel socket = ServerSocketChannel.open();
		InetSocketAddress addr = new InetSocketAddress("localhost", 1111);
		socket.bind(addr);
		
		socket.configureBlocking(false);
		
		int ops = socket.validOps();
		SelectionKey key = socket.register(selector, ops);
		
		while(true) {
			System.out.println("Im a server");
			
			selector.select();
			Iterator<SelectionKey> crunchifyIterator = selector.selectedKeys().iterator();
			 
			while (crunchifyIterator.hasNext()) {
				SelectionKey myKey = crunchifyIterator.next();
 
				if (myKey.isAcceptable()) {
					SocketChannel s = socket.accept();
					
					s.configureBlocking(false);
					s.register(selector, SelectionKey.OP_READ);
				}
				else if(myKey.isReadable()) {
					SocketChannel s = (SocketChannel) myKey.channel();
					ByteBuffer b = ByteBuffer.allocate(256);
					s.read(b);
					System.out.println(b.array().toString());
					
				}
			
		}
	}
}
}