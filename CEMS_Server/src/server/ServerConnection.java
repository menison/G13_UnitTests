package server;

import gui.ServerController;

public class ServerConnection {

	final public static int DEFAULT_PORT = 5556;
	public static EchoServer server;

	/**start the server for listening to client
	 * @param userport
	 * @param serverController
	 */
	public static void runServer(String userport, ServerController serverController) {
		int port = 0;
		try {
			port = Integer.parseInt(userport);
		} catch (Throwable t) {
			port = DEFAULT_PORT;
		}
		if (server == null) {
			server = new EchoServer(port);
			EchoServer.SC = serverController;
		}
		if (!server.isListening()) {
			try {
				server.listen();
			} catch (Exception ex) {

				EchoServer.SC.addToTextArea("ERROR - Could not listen for clients!");
			}
		}

	}

	/**stop the server for listening to client
	 * @param userport
	 * @param serverController
	 */
	public static void stopServer(ServerController serverController) {
		if (server == null) {
			serverController.addToTextArea("the server is OFF.");
			return;
		}
		if (server.isListening()) {
			server.stopListening();
		}

	}

}
