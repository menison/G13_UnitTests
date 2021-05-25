package logics;

import java.util.ArrayList;

import common.Operation;
import entities.Message;
import gui.ServerController;
import ocsf.server.ConnectionToClient;

public class LogicController {
	private static ArrayList<ClientConnection> client = null;

	public static void UpdateClientTable(Object msg, ConnectionToClient connection) {
		ClientConnection newClient = new ClientConnection(connection);
		Message receivedMessage=(Message) msg;
		if (client == null) {
			client = new ArrayList<ClientConnection>();
			client.add(newClient);
		} else {
			for (int i = 0; i < client.size(); i++) {
				if (!client.get(i).getHostName().equals(newClient.getHostName()))
					client.add(newClient);
				else
					client.get(i).setStatus("Connected");
			}
		}
		if (receivedMessage.getOperation().equals(Operation.Logout))
			for (int i = 0; i < client.size(); i++)
				if (client.get(i).getHostName().equals(newClient.getHostName()))
					client.get(i).setStatus("Disconnected");

		ServerController.sc.Update(client);
	}

}
