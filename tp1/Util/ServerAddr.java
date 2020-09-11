

import java.io.InputStreamReader;
import java.io.IOException; 
import java.io.BufferedReader;

public class ServerAddr {
    public String askAddr() throws InvalidIpAddressException, IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("Please enter the server ip address:");
        String ip = input.readLine();

        final String IP_PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
		if (!ip.matches(IP_PATTERN)) {
			throw new InvalidIpAddressException();
		}

        return ip;
    }

    public int askPort() throws InvalidPortException, IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Enter the port of the server:");
        int port = Integer.parseInt(input.readLine());
        
		if (port < 5000 || port > 5050) {
			throw new InvalidPortException();
        }
        
        return port;
    }
}
