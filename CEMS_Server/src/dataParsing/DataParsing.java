package dataParsing;

import common.Permission;
import database.GetLogin;
import entities.Message;
import server.EchoServer;

/**
 * A function that includes all the cases in which 
 * a message is sent between the client and the server
 *
 */
public class DataParsing {

	public static Message Start(Object msg) {
		Message receivedMessage;
		if (msg instanceof Message)
			receivedMessage = (Message) msg;
		else {
			EchoServer.SC.addToTextArea("Cant Cast msg");
			return null;
		}
		switch (receivedMessage.getOperationType()) {
		
		case Login:
			return GetLogin.userLoginData(receivedMessage);
		default:
			break;
				
		
		}
		return null;
	}

	/**set the permission for account 
	 * @param password1
	 * @param password2
	 * @return if password1 equals password2 true else false 
	 */
	public static Permission getPermission(String password1, String password2) {
		return password1.equals(password2) ? Permission.yes : Permission.no;
	}

}
