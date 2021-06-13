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
	GetAmountOfTests,
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
	GetExtensionRequests
}