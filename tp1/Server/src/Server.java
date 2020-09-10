import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Server {
	int port;
	String ip;
	private static ServerSocket listenner;
	
	/**
	* Creates a default Server object without parameters
	*/
	public Server() {
		this.port = 5000;
		this.ip = "0.0.0.0";
	}
	
	/**
	* Creates a Server object with parameters
	* @param  port	the port to connect to the server
	* @param  ip	the IP address of the server
	*/
	public Server(int port, String ip) {
		this.port = port;
		this.ip = ip;
	}
	
	/**
	* Starts the server application
	* @return void
	*/
	public void startServer() throws Exception {
		int nClients = 0;
		// Create connection
		this.listenner = new ServerSocket();
		this.listenner.setReuseAddress(true);
		InetAddress serverIpAddress = InetAddress.getByName(this.ip);
		// Associate IP address and port to connection
		this.listenner.bind(new InetSocketAddress(serverIpAddress, this.port));
		
		System.out.format("Server is running on %s:%d\n", this.ip, this.port);
		
		try {
			// Run ClientHandler for each new client connected
			while(true) {
				new ClientHandler(this.listenner.accept(), ++nClients).run();
			}
		}
		finally {
			// Close connection
			this.listenner.close();
		}
		
	}
	
	/**
	* Add a user to the users' database
	* @param  user	the User object to add
	* @return void
	*/
	public void addUser(User user) {
		// write user to db (json)
	}

	/**
	* Add a user to the users' database
	* @return		an array of all users on the database
	*/
	public User[] readUsersDatabase() {
		return new User[] {new User("a", "b")};
	}
	
	/**
	* Search for a user on the database to check if it's there
	* @param  user	the user to find on the database
	* @return		true if the user is found, false if not
	*/
	public boolean authenticateUser(User user) {
		// authenticate user by searching for username and password in db
		return false;
	}
	
	/**
	* Apply the Sobel filter on the picture
	* @param  picture on which to apply the filter
	* @return void
	*/
	public void applySobelFilter(/*picture*/) {
		
	}
	
	
	// TODO other fct to receive command from client and send command to client
	// TODO manage pictures (send header and data/buffer --> check most efficient way) to apply filter
	
}
