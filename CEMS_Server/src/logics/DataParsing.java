package logics;



import java.sql.SQLException;

import common.Permission;
import dataParsing.ActivateTest;
import dataParsing.GetFullTestTable;
import dataParsing.GetTestTable;
import dataParsing.TestCodeValidation;
import database.GetLogin;
import entities.Message;
import server.EchoServer;

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
		case GetTestTable:
			return GetTestTable.getTestTable(receivedMessage);
		case SendTestCode:
			return TestCodeValidation.validateTestCode(receivedMessage);
		case GetFullTestTable:
			return GetFullTestTable.getTestTable(receivedMessage);
		case ActivateTestCode:
			return ActivateTest.validateAndActivate(receivedMessage);
		default:
			break;
				
	
		}
		return null;
	}
	
	public static Permission getPermission(String password1, String password2) {
		return password1.equals(password2) ? Permission.yes : Permission.no;
	}

}
