package common;

/**
 * All the operation of the system
 *
 */
public enum Operation {
	
	Operation1,
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

	RequestExtensionFailed,
	RequestExtensionSuccess,
	GetAmountOfQuestions,
	GetCourseAmountOfQuestions,
	AddQuestionToDatabase,
	IncrementNumOfQuestionsInCourse,
	AddNewTest,
	GetQuestionInfo,
	GetTestsActivatedByTeacher,
	GetAmountOfTests,
	GetTestConfirmationTable,
	GetCalculatedGradeForConfirmation,
	GetTestsActivatedByTeachger,
	RequestExtension,
	ChangeAmountOfTestsInCourseTable,
	GetExtensionRequests, 
	ApproveExtensionRequests,
	DeclineExtensionRequests
}