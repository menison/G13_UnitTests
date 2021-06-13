package dataParsing;

import entities.Message;
import gui.ActivateTestController;
import request.AddTeacherTestsToDM;
import request.FullTestTable;
<<<<<<< HEAD

=======

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
import request.GenerateQuestionID;
<<<<<<< HEAD

=======

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git

import request.GetCurrentExecEmail;

<<<<<<< HEAD

=======

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
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
<<<<<<< HEAD

=======

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
		case AddQuestionToDatabase:
			GenerateQuestionID.setAddQuestionMsg(receivedMessage);
			break;
		case IncrementNumOfQuestionsInCourse:
			GenerateQuestionID.setIncNumOfQuestionMsg(receivedMessage);
			break;
<<<<<<< HEAD

=======

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
		case ChangeAmountOfTestsInCourseTable:
			SetTestsValues.changeAmountOfTestsInCourseTable(receivedMessage);
		case GetExtensionRequests:
			PrincipalExtentionRequests.principalSetExtentionRequests(receivedMessage);
			break;

		case RequestExtensionFailed:{
			HandleActivateStatus.activateFailed(receivedMessage);
			break;
		}
		case RequestExtensionSuccess:{
			HandleActivateStatus.activateSuccess(receivedMessage);
			break;
		}
			
		case GetTestConfirmationTable:
<<<<<<< HEAD
			SetTestConfirmationTable.set(receivedMessage);
=======
			SetTestConfirmationTable.set(receivedMessage);
		case ApproveExtensionRequests:
			PrincipalExtentionRequests.principalApproveExtentionRequests(receivedMessage);
		case DeclineExtensionRequests:
			PrincipalExtentionRequests.principalDeclineExtentionRequests(receivedMessage);
		case GetTestsActivatedByTeachger:
			AddTeacherTestsToDM.add(receivedMessage);
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
		default:
			break;
		}
		
	}
	
	
}