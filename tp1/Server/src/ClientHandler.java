import java.io.DataInputStream;
import java.io.DataOutputStream;
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
	* Run ClientHandler to send messages to client
	*/
	public void run() {
		try {
			// Out channel to send messages to client
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Hello from server, you are client" + this.nClients);
			
			// In channel to receive messages from client
			DataInputStream in = new DataInputStream(this.socket.getInputStream());
			String message = in.readUTF();
			System.out.println("Hey! I received a message from a client: " + message);
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
	
}
