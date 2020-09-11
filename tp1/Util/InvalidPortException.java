

public class InvalidPortException extends Exception {
	InvalidPortException() {
		super("Invalid port. You should enter a valid port number between 5000 and 5050.");
	}
}
