package logics;

import common.Permission;
<<<<<<< HEAD
import dataParsing.ActivateTest;
=======
import dataParsing.ActivateTest;
<<<<<<< HEAD

=======

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
import dataParsing.AddQuestionOperations;
<<<<<<< HEAD

=======

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
import dataParsing.GetCurrentExecutionExamEmail;
<<<<<<< HEAD
import dataParsing.GetDurationForExecTest;
=======
import dataParsing.GetDurationForExecTest;

<<<<<<< HEAD

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
import dataParsing.AddTestsOperations;
<<<<<<< HEAD
import dataParsing.CheckIfTestIsLocked;
=======
=======
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git

import dataParsing.AddTestsOperations;
import dataParsing.ExtensionRequest;
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
import dataParsing.GetFullTestTable;
import dataParsing.GetTestConfirmationTable;
import dataParsing.GetTestTable;
import dataParsing.GetTimeForExecExam;
import dataParsing.HandleTestsActivatedByTeacher;
import dataParsing.ManualTestDownloader;
import dataParsing.ManualTestUploader;
import dataParsing.PrincipalGetExtentionRequests;
import dataParsing.PrincipalGetReport;
import dataParsing.SetCompletedStudentExam;
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
<<<<<<< HEAD
			return TeacherGetAllSelfExecutedTests.getAllSelfExecutedTests(receivedMessage);
=======
			return TeacherGetAllSelfExecutedTests.getAllSelfExecutedTests(receivedMessage);
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
		case getInstructionsAndMail:
			return GetCurrentExecutionExamEmail.getComposerEmail(receivedMessage);
		case GetTimeForTestInExecution:
			return GetDurationForExecTest.getDuration(receivedMessage);
		case SetCompletedExam:
<<<<<<< HEAD
			return SetCompletedStudentExam.setExam(receivedMessage);
=======
			return SetCompletedStudentExam.setExam(receivedMessage);
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
		case GetSubjectsAndCourses:
			return AddTestsOperations.getSubjectsAndCourses(receivedMessage);
		case GetQuestions:
			return AddTestsOperations.getQuestions(receivedMessage);
		case GetAmountOfTests:
			return AddTestsOperations.getAmountOfTests(receivedMessage);
		case GetAmountOfQuestions:
			return AddQuestionOperations.getAmountOfQuestions(receivedMessage);
		case GetCourseAmountOfQuestions:
			return AddQuestionOperations.getAmountOfCourseQuestions(receivedMessage);
		case AddNewTest:
			return AddTestsOperations.addTest(receivedMessage);
<<<<<<< HEAD

=======

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
		case AddQuestionToDatabase:
			return AddQuestionOperations.addQuestionToDB(receivedMessage);
		case IncrementNumOfQuestionsInCourse:
			return AddQuestionOperations.increaseNumOfQuestionsInCourse(receivedMessage);
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
		case ChangeAmountOfTestsInCourseTable:
			return AddTestsOperations.changeAmountOfTestsInCourseTable(receivedMessage);
<<<<<<< HEAD
		case CheckIfTestIsLocked:
			return CheckIfTestIsLocked.checkForLockedTest(receivedMessage);
		case getTimeForActiveExam:
			return GetTimeForExecExam.getTime(receivedMessage);
=======
		case GetTestsActivatedByTeachger:
			return HandleTestsActivatedByTeacher.returnTestsByTeacher(receivedMessage);
		case GetExtensionRequests:
			return PrincipalGetExtentionRequests.getExtensions(receivedMessage);
		case GetTestConfirmationTable:
<<<<<<< HEAD
			return GetTestConfirmationTable.get(receivedMessage);
=======
			return GetTestConfirmationTable.get(receivedMessage);

		case ApproveExtensionRequests:
			return PrincipalGetExtentionRequests.principalApproveRequests(receivedMessage);
		case DeclineExtensionRequests:
			return PrincipalGetExtentionRequests.principalDeclineRequests(receivedMessage);

		case RequestExtension:
			return ExtensionRequest.handleExtension(receivedMessage);
			

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
		default:
			break;
		}
		return null;
	}
	
	public static Permission getPermission(String password1, String password2) {
		return password1.equals(password2) ? Permission.yes : Permission.no;
	}

}