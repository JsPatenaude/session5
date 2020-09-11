

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {
	private Socket socket;
	private int nClients;
	
	/**
	* Creates a ClientHandler object
	* @param  socket	the socket for the connection
	* @param  nClients	the number of current clients
	*/
	public ClientHandler(Socket socket, int nClients) {
		this.socket = socket;
		this.nClients = nClients;
		System.out.format("New Connection with client%d at %s\n", nClients, socket);
	}
	
	/**
	* Run ClientHandler to communicate with client
	*/
	public void run() {
		try {
			// In channel to receive messages from client
			DataInputStream in = new DataInputStream(this.socket.getInputStream());
			// Out channel to send messages to client
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			
			// TODO receive message from client with username and password (and handle it)
			String message = in.readUTF();
			// TODO remove this println, because we don't want everybody to see username/password
			System.out.println(message);
			
			// TODO send message to client to tell if authentication was successful or not
			out.writeUTF("Fine you can have access...");

			// Image received from client
			// TODO don't save the image but only convert it to bufferedImage and apply filter, then send it back to client
			FileOutputStream imageReceived = new FileOutputStream(System.getProperty("user.dir") + "/Server/src/bitcoin.jpg");
            int i = 0;
            while ((i = in.read()) > -1) {
            	imageReceived.write(i);
            }
            
            // TODO maybe apply filter and send back image from Server.java?
            // Apply filter on image
            
            // Send image back to client
			
		}
		catch(IOException e) {
			System.out.format("Exception while handling client%d: %s\n", this.nClients, e);
		}
		finally {
			try {
				this.socket.close();
			}
			catch (IOException e) {
				System.out.format("Exception while closing socket %s: %s\n", this.socket, e);
			}
			System.out.format("Connection with client%d closed\n", this.nClients);
		}
	}
	
	
	/**
	* Get and handle the image received from the client
	* @return void  
	*/
	public void getImageFromClient() {
		
	}
	
}
