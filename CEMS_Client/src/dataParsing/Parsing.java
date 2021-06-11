package dataParsing;

import entities.Message;
import request.FullTestTable;
import request.Login;
import request.ManualTestDownloader;
import request.PrincipalSetReport;
import request.StudentTestTable;
import request.TestCodeValidation;

public class Parsing {
	/**
	 * @param This class receives all types of messages resulting from clicks in the
	 *             system and routes them to the appropriate action for each of
	 *             them.
	 */
	public static void Message(Message receivedMessage) {

		
		switch (receivedMessage.getOperationType()) {
		
		case Login:
			Login.receiveLogin(receivedMessage);
			break;
		case GetTestTable:
			StudentTestTable.setTable(receivedMessage);
			break;
		case SendTestCode:
			TestCodeValidation.informUser(receivedMessage);
			break;
		case GetFullTestTable:
			FullTestTable.setTable(receivedMessage);
			break;
		case DownloadManualTest:
			ManualTestDownloader.simulateManualTestExecution(receivedMessage);
			break;
		case UploadManualTest:
		case PrincipalGetReport:
			PrincipalSetReport.generateReport(receivedMessage);
			break;
			
		default:
			break;
		}
		
	}
	
	
}