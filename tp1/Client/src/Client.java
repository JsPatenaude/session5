import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

public class Client {
	int port;
	String ip;
	private static Socket socket;
	
	/**
	* Creates a default Client object without parameters
	*/
	public Client() {
		this.port = 5000;
		this.ip = "0.0.0.0";
	}
	
	/**
	* Creates a Client object with parameters
	* @param  port	the port to connect to the server
	* @param  ip	the IP address of the server
	*/
	public Client(int port, String ip) {
		this.port = port;
		this.ip = ip;
	}
	
	/**
	* Starts the client application
	* @return void
	*/
	public void startClient() throws Exception {
		// Create connection with server
		this.socket = new Socket(this.ip, this.port);
		// In channel to receive messages from server
		DataInputStream in = new DataInputStream(this.socket.getInputStream());
		// Out channel to send messages to server
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		// Log from connection to server
		System.out.format("Server is running on %s:%d\n", this.ip, this.port);
		
		// TODO send username and password
		// Send username and password to server for the authentication
		out.writeUTF("this is a username and this is a password");
		
		// Receive message from server to know if authentication was successful or not
		String message = in.readUTF();
		System.out.println(message);
		
		// TODO if authentication was not good, retry (maybe while loop to try again, but after 2-3times --> close socket and kill client)
		
		
		// Image to send to server
		FileInputStream imageToSend = new FileInputStream (System.getProperty("user.dir") + "/Client/src/bitcoin.jpg");
		int i = 0;
		while ((i = imageToSend.read()) > -1) {
			out.write(i);
		}
		
		// TODO wait for server to send back image
		// TODO save image (same name or name_filter?)
		
		// Close connection with server
		this.socket.close();
	}
	
}



