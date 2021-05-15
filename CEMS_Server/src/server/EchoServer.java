package server;

import logic.*;

import entities.Message;

import gui.ServerController;
import ocsf.server.*;

/**
 * our connection to client , receive message from client and send response to client
 *
 */
public class EchoServer extends AbstractServer {

	final public static int DEFAULT_PORT = 5556;
	private Message returnMessage;

	public static ServerController SC;

	public EchoServer(int port) {
		super(port);
	}

	
	/**
	 *Receives a message from the client and converts it to a message that the server can read
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		LogicController.UpdateClientTable(msg, client);
		returnMessage = DataParsing.Start(msg);
		
		sendToAllClients(returnMessage);
	}

	/**
	 *	prints when server start
	 */
	protected void serverStarted() {

		SC.addToTextArea("Server listening for connections on port " + getPort());
	}
	/**
	 *	prints when server stop
	 */
	protected void serverStopped() {

		SC.addToTextArea("Server has stopped listening for connections.");

	}

}
