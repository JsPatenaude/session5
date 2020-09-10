import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception, IOException, InvalidPortException, InvalidIpAddressException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Enter the port of the server:");
		int port = Integer.parseInt(input.readLine());
		if (port < 5000 || port > 5050) {
			throw new InvalidPortException();
		}
		
		System.out.println("Enter the IP address of the server:");
		String ip = input.readLine();
		final String IP_PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
		if (!ip.matches(IP_PATTERN)) {
			throw new InvalidIpAddressException();
		}
		
		Client client = new Client(port, ip);
		client.startClient();
	}
}

