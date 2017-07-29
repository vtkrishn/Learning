package javaproject.server;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadServer implements Runnable {
    int serverPort = 8080;
    ServerSocket serverSocket;
    Thread       runningThread;
    boolean      isStopped    = false;
    public SingleThreadServer(int port) {
        this.serverPort = port;
    }

    public static void main(String[] args){
        SingleThreadServer server = new SingleThreadServer(9000);
        new Thread(server).start();
        while(true){
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("Stopping Server");
        //server.stop();
    }

    public void run() {
        synchronized(this){
            runningThread = Thread.currentThread();
        }
        openServerSocket();

        while(!isStopped){
            Socket clientSocket = null;

            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped) {
                                    System.out.println("Server Stopped.") ;
                                    return;
                                }
                                throw new RuntimeException(
                                    "Error accepting client connection", e);
            }
            try {
                            processClientRequest(clientSocket);
                        } catch (IOException e) {
                            //log exception and go on to next request.
                        }
        }
        System.out.println("Server Stopped.");
    }

    private void processClientRequest(Socket clientSocket)
        throws IOException {
        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();
                long time = System.currentTimeMillis();
        output.write(("HTTP/1.1 200 OK\n\n<html><body>" +
                        "Singlethreaded Server: " +
                        time +
                        "</body></html>").getBytes());
                output.close();
                input.close();
                System.out.println("Request processed: " + time);
    }
    public synchronized void stop(){
            this.isStopped = true;
            try {
                this.serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException("Error closing server", e);
            }
        }
    private void openServerSocket() {
            try {
                this.serverSocket = new ServerSocket(this.serverPort);
            } catch (IOException e) {
                throw new RuntimeException("Cannot open port 8080", e);
            }
        }
}
