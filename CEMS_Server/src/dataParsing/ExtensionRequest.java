package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Extension;
import entities.Message;
import gui.ServerController;

public class ExtensionRequest {
	public static Message handleExtension(Message msg){
		Extension exten= (Extension)msg.getObj();
		ResultSet extensionRec;
		extensionRec = Query.getReport("SELECT * FROM extensionrequest WHERE TestCode = '"+exten.getTestCode()+"'");
		try {
			if(extensionRec.next()) {

				return new Message(Operation.RequestExtensionFailed,"there is already an extension request for this exam");
			}else {
				Query.update("INSERT INTO `query`.`extensionrequest` (`TestCode`, `RequestedBy`, `newDuration`, `Reason`, `isAuthorized`, isRelevant) "
						+ "VALUES ('"+exten.getTestCode()+"', '"+exten.getRequestedBy()+"', '"+exten.getNewDuration()+"', '"+exten.getReason()+"', '"+exten.getIsAuthorized()+"',"+exten.getIsRelevant()+");");
				ServerController.sc.addToTextArea("extension request for exam with code:"+exten.getTestCode()+" was sent by teacher:"+exten.getRequestedBy());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(Operation.RequestExtensionFailed,"DATABASE CONNECTION FAILED");
		}
		
		
		
		
		
		
		return new Message(Operation.RequestExtensionSuccess,"Extension exam with code:"+exten.getTestCode()+" was requested");

	}
}
