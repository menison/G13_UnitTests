package dataParsing;

import entities.Message;
import request.AddTeacherTestsToDM;
import request.AfterGradeAuth;
import request.EditTesterHandler;
import request.FullTestTable;
import request.GenerateQuestionID;
import request.GetCurrentExecEmail;
import request.HandleActivateStatus;
import request.HandleCheaters;
import request.Login;
import request.ManualTestDownloader;
import request.ManualTestUploader;
import request.PrincipalExtentionRequests;
import request.QuestionInfoHandler;
import request.SetDurationForExecTest;
import request.SetIfCurrentExecutedTestIsActive;
import request.SetReport;
import request.SetRequestedTest;
import request.SetTestConfirmationTable;
import request.SetTestsValues;
import request.SetTimeForExecExam;
import request.StudentTestTable;
import request.TeacherSetTableForSelfTests;
import request.TestCodeValidation;
import request.TestLocker;

public class Parsing {
	/**
	 * This class receives messages represnting different requests
	 *  resulting from clicks in the system and routes each and every 
	 *  one of them to their appropriate handlers.
	 */
	
	/**
	 * This method  routes the receivedMessage to its appropriate case in this tremendous switch
	 * case of ours, resulting in the requested actions to be executed to the user's will.
	 * @param receivedMessage - A message that contains the desired operation to be executed.
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
			ManualTestUploader.checkUploadStatus(receivedMessage);
			break;
		case GetReport:
			SetReport.generateReport(receivedMessage);
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
		case UpdateTest:
			EditTesterHandler.getMsg(receivedMessage);
		case CheckFraud:
			HandleCheaters.handle(receivedMessage);
		case LockTest:
			TestLocker.informUser(receivedMessage);
		break;
		case GetTestForReview:
			SetRequestedTest.setTest(receivedMessage);
			break;
		default:
			break;
		}
		
	}
	
	
}