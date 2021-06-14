package dataParsing;

import entities.Message;


import gui.ActivateTestController;
import request.AddTeacherTestsToDM;
import request.FullTestTable;





import request.GenerateQuestionID;




import request.GetCurrentExecEmail;




import request.HandleActivateStatus;


import request.AddTeacherTestsToDM;
import request.AfterGradeAuth;
import request.EditTesterHandler;
import request.FullTestTable;
import request.GetCurrentExecEmail;
import request.HandleActivateStatus;
import request.GenerateQuestionID;


import request.AddTeacherTestsToDM;
import request.AfterGradeAuth;
import request.FullTestTable;
import request.GetCurrentExecEmail;
import request.HandleActivateStatus;
import request.GenerateQuestionID;

import request.Login;
import request.ManualTestDownloader;
import request.PrincipalSetReport;
import request.PrincipalExtentionRequests;

import request.PrincipalSetReport;
import request.QuestionInfoHandler;
import request.SetTestConfirmationTable;


import request.SetTestConfirmationTable;

import request.SetDurationForExecTest;
import request.SetTestsValues;
import request.SetIfCurrentExecutedTestIsActive;
import request.SetTimeForExecExam;
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
			break;
		case CheckIfTestIsLocked:
			SetIfCurrentExecutedTestIsActive.setActive(receivedMessage);
			break;
		case getTimeForActiveExam:
			SetTimeForExecExam.setTime(receivedMessage);
			SetTestsValues.changeAmountOfTestsInCourseTable(receivedMessage);
			break;
		case GetExtensionRequests:
			PrincipalExtentionRequests.principalSetExtentionRequests(receivedMessage);
			break;
		case RequestExtensionFailed:
			HandleActivateStatus.activateFailed(receivedMessage);
			break;	
		case RequestExtensionSuccess:
			HandleActivateStatus.activateSuccess(receivedMessage);
			break;	
		case GetTestConfirmationTable:
			SetTestConfirmationTable.set(receivedMessage);
			break;
		case GetQuestionInfo:
			QuestionInfoHandler.addToDB(receivedMessage);
			break;
		case SubmitQuestionInfo:
			QuestionInfoHandler.getMsg(receivedMessage);
			break;
		case ConfirmTestWithChanges:
			AfterGradeAuth.notifyUser(receivedMessage);
			break;
		case ConfirmTestWithoutChanges:
			AfterGradeAuth.notifyUser(receivedMessage);
			break;
		case ApproveExtensionRequests:
			PrincipalExtentionRequests.principalApproveExtentionRequests(receivedMessage);
			break;
		case DeclineExtensionRequests:
			PrincipalExtentionRequests.principalDeclineExtentionRequests(receivedMessage);
			break;
		case GetTestsActivatedByTeachger:
			AddTeacherTestsToDM.add(receivedMessage);
			break;
		case GetTestByID:
			EditTesterHandler.addToDB(receivedMessage);
			break;
		default:
			break;
		}
		
	}
	
	
}