package application;

import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import entities.Message;
import ocsf.client.AbstractClient;
import dataParsing.Parsing;

/**
 * A class that extends OCSF's AbstractClient and handles incoming messages
 * from both client and server.
 */
public class ChatClient extends AbstractClient { 
	
	public static boolean awaitResponse = false;

	public ChatClient(String host, int port) throws IOException {
		super(host, port);
	}

	/**
	 * This function handles a message from server.
	 *@param msg -> An Object that contains a message from server.
	 */
	public void handleMessageFromServer(Object msg) {
		Message receivedMessage = (Message) msg;
		awaitResponse = false;
		Parsing.Message(receivedMessage);

	}

	/**This function handles a message from client.
	 * @param message -> An Object that contains a message from client.
	 */
	public void handleMessageFromClient(Message message) {
		try {
			openConnection();
			awaitResponse = true;
			sendToServer(message);
			while (awaitResponse) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			closeConnection();
		} catch (IOException e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Error Connection");
			errorAlert.setContentText("cant connect to server");
			errorAlert.showAndWait();
		}

	}

	/**
	 * This function closes the connection and exits the system totally.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}

}
