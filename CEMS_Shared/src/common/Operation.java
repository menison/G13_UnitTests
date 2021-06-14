package common;

/**
 * All the operation of the system
 *
 */
public enum Operation {
	
	Login,
	Logout,
	Operation3,
	SendTestCode,
	DownloadManualTest,
	UploadManualTest,
	LastOperation,
	GetTestTable,
	getInstructionsAndMail,
	GetFullTestTable,
	GetReport,
	GetTestsForTeacherReport,
	ActivateTestCode,
	GetTimeForTestInExecution,
	GetTimeForActiveExam,
	SetCompletedExam,
	CheckIfTestIsLocked,
	GetSubjectsAndCourses,
	GetQuestions,
	GetQuestionTable,
	ActivateTestCodeFailed,
	ActivateTestCodeSuccess,
	GetAmountOfTests,
	RequestExtensionFailed,
	RequestExtensionSuccess,
	GetAmountOfQuestions,
	GetCourseAmountOfQuestions,
	AddQuestionToDatabase,
	IncrementNumOfQuestionsInCourse,
	AddNewTest,
	GetQuestionInfo,
	GetTestsActivatedByTeacher,
	GetTestConfirmationTable,
	GetCalculatedGradeForConfirmation,
	GetTestsActivatedByTeachger,
	RequestExtension,
	ChangeAmountOfTestsInCourseTable,
	ConfirmTestWithChanges,
	ConfirmTestWithoutChanges,
	getTimeForActiveExam,
	GetExtensionRequests,
	ApproveExtensionRequests,
	DeclineExtensionRequests,
	SubmitQuestionInfo,
	GetTestByID,
	UpdateTest,
	CheckFraud,
	LockTest


}