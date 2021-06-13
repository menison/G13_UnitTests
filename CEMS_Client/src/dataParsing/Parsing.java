package dataParsing;

import entities.Message;
import gui.ActivateTestController;
import request.AddTeacherTestsToDM;
import request.FullTestTable;
import request.HandleActivateStatus;
import request.Login;
import request.ManualTestDownloader;
import request.PrincipalSetReport;
import request.SetTestsValues;
import request.StudentTestTable;
import request.TeacherSetTableForSelfTests;
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
		case Logout:
			Login.receivedLogOut(receivedMessage);
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
			break;
		case GetReport:
			PrincipalSetReport.generateReport(receivedMessage);
			break;
		case GetTestsForTeacherReport:
			TeacherSetTableForSelfTests.setTableForSelfTests(receivedMessage);
			break;
		case GetSubjectsAndCourses:
			SetTestsValues.setSubjects(receivedMessage);
			break;
		case GetQuestions:
			SetTestsValues.setQuestions(receivedMessage);
			break;
		case ActivateTestCodeFailed:
		HandleActivateStatus.activateFailed(receivedMessage);
			break;
		case ActivateTestCodeSuccess:
		HandleActivateStatus.activateSuccess(receivedMessage);
			break;
<<<<<<< HEAD
		case GetTestsActivatedByTeachger:
			AddTeacherTestsToDM.add(receivedMessage);
=======
		case GetAmountOfTests:
			SetTestsValues.setAmountOfTests(receivedMessage);
			break;
		case AddNewTest:
			SetTestsValues.setAmountOfTests(receivedMessage);
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
			break;
		default:
			break;
		}
		
	}
	
	
}