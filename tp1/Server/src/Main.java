import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
// import ServerAddr;

public class Main {
	public static void main(String[] args) throws Exception, IOException, InvalidPortException, InvalidIpAddressException {
		var serverAddr = new ServerAddr();

		String ip = serverAddr.askAddr();
		int port = serverAddr.askPort();
		
		Server server = new Server(port, ip);
		server.startServer();
	}
}

//TODO documenting each fct in every file (java doc)
//TODO keep all external libraries to explain why we used them in the report


