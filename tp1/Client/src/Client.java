import java.io.DataInputStream;
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
	
	public void startClient() throws Exception {
		// Create connection with server
		this.socket = new Socket(this.ip, this.port);
		
		System.out.format("Server is running on %s:%d\n", this.ip, this.port);
		
		// In channel to receive messages from server
		DataInputStream in = new DataInputStream(this.socket.getInputStream());
		String message = in.readUTF();
		System.out.println(message);
		
		// Close connection with server
		this.socket.close();
	}
}



