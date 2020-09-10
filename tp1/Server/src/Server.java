
public class Server {
	int port;
	String ip;
	
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
	* Starts the server
	* @return void
	*/
	public void startServer() {
		
	}
	
	/**
	* Stops the server
	* @return void
	*/
	public void stopServer() {
		
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