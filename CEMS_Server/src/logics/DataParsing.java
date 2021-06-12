package logics;

import common.Permission;
import dataParsing.ActivateTest;
<<<<<<< HEAD
import dataParsing.AddTestsOperations;
=======
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
import dataParsing.GetFullTestTable;
import dataParsing.GetTestTable;
import dataParsing.ManualTestDownloader;
import dataParsing.ManualTestUploader;
import dataParsing.PrincipalGetReport;
import dataParsing.TeacherGetAllSelfExecutedTests;
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
		case Logout:
			return GetLogin.logOut(receivedMessage);
		case GetTestTable:
			return GetTestTable.getTestTable(receivedMessage);
		case SendTestCode:
			return TestCodeValidation.validateTestCode(receivedMessage);
		case GetFullTestTable:
			return GetFullTestTable.getTestTable(receivedMessage);
		case ActivateTestCode:
			return ActivateTest.validateAndActivate(receivedMessage);	
		case DownloadManualTest:
			return ManualTestDownloader.downloadManualTest(receivedMessage);
		case UploadManualTest:
			return ManualTestUploader.uploadManualTest(receivedMessage);
		case GetReport:
			return PrincipalGetReport.getReport(receivedMessage);
		case GetTestsForTeacherReport:
			return TeacherGetAllSelfExecutedTests.getAllSelfExecutedTests(receivedMessage);
		case GetSubjectsAndCourses:
			return AddTestsOperations.getSubjectsAndCourses(receivedMessage);
		case GetQuestions:
			return AddTestsOperations.getQuestions(receivedMessage);
		default:
			break;
		}
		return null;
	}
	
	public static Permission getPermission(String password1, String password2) {
		return password1.equals(password2) ? Permission.yes : Permission.no;
	}

}