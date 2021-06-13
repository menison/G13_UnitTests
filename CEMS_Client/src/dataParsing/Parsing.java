package dataParsing;

import entities.Message;
import gui.ActivateTestController;
import request.AddTeacherTestsToDM;
import request.FullTestTable;

import request.GenerateQuestionID;


import request.GetCurrentExecEmail;


import request.HandleActivateStatus;

import request.Login;
import request.ManualTestDownloader;
import request.PrincipalExtentionRequests;
import request.PrincipalSetReport;

import request.SetTestConfirmationTable;

import request.SetDurationForExecTest;

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

		case getInstructionsAndMail:
			GetCurrentExecEmail.setEmail(receivedMessage);
			break;
		case GetTimeForTestInExecution:
			SetDurationForExecTest.setDuration(receivedMessage);

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
		case GetTestsActivatedByTeacher:
			AddTeacherTestsToDM.add(receivedMessage);
		case GetAmountOfTests:
			SetTestsValues.setAmountOfTests(receivedMessage);
			break;
		case GetAmountOfQuestions:
			GenerateQuestionID.setQuestionAmount(receivedMessage);
			break;
		case GetCourseAmountOfQuestions:
			GenerateQuestionID.setTempQuestionAmount(receivedMessage);
			break;
		case AddNewTest:
			SetTestsValues.addNewTest(receivedMessage);
			break;

		case AddQuestionToDatabase:
			GenerateQuestionID.setAddQuestionMsg(receivedMessage);
			break;
		case IncrementNumOfQuestionsInCourse:
			GenerateQuestionID.setIncNumOfQuestionMsg(receivedMessage);
			break;

		case ChangeAmountOfTestsInCourseTable:
			SetTestsValues.changeAmountOfTestsInCourseTable(receivedMessage);
		case GetExtensionRequests:
			PrincipalExtentionRequests.principalSetExtentionRequests(receivedMessage);
			break;
		case GetTestConfirmationTable:
			SetTestConfirmationTable.set(receivedMessage);
		default:
			break;
		}
		
	}
	
	
}