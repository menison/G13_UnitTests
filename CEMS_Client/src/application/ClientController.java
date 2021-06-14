package application;

import java.io.IOException;

import entities.Message;


/**
 * This class holds an instance of ChatClient and controlls the connection and message handling
 * of A client.
 */
public class ClientController {
	ChatClient client;

	/**
	 * Constructor
	 * @param host - String representing host.
	 * @param port - int representing port.
	 */
	public ClientController(String host, int port) {
		try {
			client = new ChatClient(host, port);
		} catch (IOException e) {

			e.printStackTrace();
		      System.exit(1);
		}
	}

	/**
	 * A function that sends a message from client to server, in fact, it initiates all the ocsf
	 * message-based communication.
	 * @param message - A message that would be sent to the server.
	 */
	public void accept(Message message) {
		client.handleMessageFromClient(message);
	}
}
