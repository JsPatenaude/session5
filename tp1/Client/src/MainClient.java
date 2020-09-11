import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;

public class MainClient {
	public static void main(String[] args) throws Exception, IOException , InvalidPortException, InvalidIpAddressException {
		var serverAddr = new ServerAddr();

		String ip = serverAddr.askAddr();
		int port = serverAddr.askPort();
		
		Client client = new Client(port, ip);
		client.startClient();
	}
}

