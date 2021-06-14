package cachedUserData;

import java.util.ArrayList;
import java.util.HashSet;

import entities.ActivatedTest;
import entities.Course;
import entities.ExecutedTest;
import entities.Extension;
import entities.Field;
import entities.Question;
import entities.QuestionForCreateTest;
import entities.Report;
import entities.Test;
import entities.TestForFullTable;
import entities.TestForRequestedTest;
import entities.TestForTable;
import entities.TestToConfirm;
import entities.User;
import javafx.scene.control.TableView;

/**
 * This class saves information in a "cached" way, in a manner that allow to retrieve faster
 * information that was already brought from the DB.
 * It facilitates the variable management, and it optimizes program performance.
 */
public class DataManager {
	private static DataManager instance = null;

	private ExecutedTest testInExecution;
	private User currentUser;
	private ArrayList<TestForTable> executedExams;
	private ArrayList<TestToConfirm> testsToConfirm;
	private ArrayList<TestForFullTable> fullTestList;
	private ArrayList<Field> fields;
	private ArrayList<Course> courses;
	private ArrayList<Question> questions;
	private TableView<QuestionForCreateTest> CreateTest_tblQuestions;
	private ArrayList<Extension> extensionRequests;
	private String testID;
	private Report report;
	private TestToConfirm t;
	private String currentExecEmail;
	private String activateMsg;
	private String addTestMsg;
	private boolean activateSuccess;
	private ArrayList<ActivatedTest> teacherActivatedTests;
	private String addQuestionMsg;
	private String incQuestionNumMsg;
	private String amountOfQuestions;
	private int tempNumOfQuestionsForCourse;
	private Extension extension;
	private Test test;
	private Question question;
	private HashSet<String> suspectsForFraud;
	private TestForRequestedTest reviewTest;

	public TestForRequestedTest getReviewTest() {
		return reviewTest;
	}
	public void setReviewTest(TestForRequestedTest reviewTest) {
		this.reviewTest = reviewTest;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public void setAddQuestionMsg(String msg) {
		this.addQuestionMsg=msg;
	}
	public String getQuestionMsg() {
		return addQuestionMsg;
	}
	public void setIncQuestionNumMsg(String msg) {
		this.incQuestionNumMsg=msg;
	}
	public String getIncQuestionNumMsg() {
		return incQuestionNumMsg;
	}
	
	
	public Extension getExtension() {
		return extension;
	}


	public void setExtension(Extension extension) {
		this.extension = extension;
	}


	public String getCurrentExecEmail() {
		return currentExecEmail;
	}

	public void setCurrentExecEmail(String currentExecEmail) {
		this.currentExecEmail = currentExecEmail;

	}

	public ArrayList<ActivatedTest> getTeacherActivatedTests() {
		return teacherActivatedTests;
	}

	public void setTeacherActivatedTests(ArrayList<ActivatedTest> teacherActivatedTests) {
		this.teacherActivatedTests = teacherActivatedTests;
	}

	public String getActivateMsg() {
		return activateMsg;
	}

	public void setActivateMsg(String activateMsg) {
		this.activateMsg = activateMsg;
	}

	public boolean isActivateSuccess() {
		return activateSuccess;
	}

	public void setActivateSuccess(boolean activateSuccess) {
		this.activateSuccess = activateSuccess;

	}
	
	public void setAmountOfQuestions(String amountOfQuestions) {
		this.amountOfQuestions=amountOfQuestions;
	}
	
	public String getAmountOfQuestions() {
		return amountOfQuestions;
	}
	public void setCourseAmountQuestions(int amount) {
		this.tempNumOfQuestionsForCourse=amount;
	}
	public int getTempAmountOfQuestionsForCourse() {
		return tempNumOfQuestionsForCourse;

	}

	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}

	private DataManager() {
		this.currentUser = null;
	}
	
	/**
	 * @return instance of data manager if exist or make on if its the first call and then return him 
	 */
	public static DataManager getDataManager() {
		if(instance == null) 
			instance = new DataManager();
		return instance;
	}

	/**
	 * @return the current user
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * @param set the current user
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public void clearAll() {
		this.currentUser = null;
	}
	
	public ExecutedTest getTestInExecution() {
		return testInExecution;
	}
	
	public void setExecutedExams(ArrayList<TestForTable> testList) {
		this.executedExams = testList;
	}
	
	public ArrayList<TestForTable> getExecutedExams() {
		return executedExams;
	}

	public void setTestInExecution(ExecutedTest testInExecution) {
		this.testInExecution = testInExecution;
	}
	public void setFullTable(ArrayList<TestForFullTable> testList) {
		this.fullTestList = testList;
	}
	public ArrayList<TestForFullTable> getFullTable() {
		return this.fullTestList;
	}
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
	
	public ArrayList<Field> getFields() {
		return fields;
	}

	public void setFields(ArrayList<Field> fields) {
		this.fields = fields;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> question) {
		this.questions = question;
	}

	public TableView<QuestionForCreateTest> getCreateTest_tblQuestions() {
		return CreateTest_tblQuestions;
	}

	public void setCreateTest_tblQuestions(TableView<QuestionForCreateTest> createTest_tblQuestions) {
		CreateTest_tblQuestions = createTest_tblQuestions;
	}
	public String getAddTestMsg() {
		return addTestMsg;
	}

	public void setAddTestMsg(String addTestMsg) {
		this.addTestMsg = addTestMsg;
	}

	public ArrayList<TestToConfirm> getTestsToConfirm() {
		return testsToConfirm;
	}

	public void setTestsToConfirm(ArrayList<TestToConfirm> testsToConfirm) {
		this.testsToConfirm = testsToConfirm;
	}


	public TestToConfirm getT() {
		return t;

	}
	
	public ArrayList<Extension> getExtensionRequests() {
		return extensionRequests;

	}

	public void setT(TestToConfirm t) {
		this.t = t;
	}


	public void setExtensionRequests(ArrayList<Extension> extensionRequests) {
		this.extensionRequests = extensionRequests;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public HashSet<String> getSuspectsForFraud() {
		return suspectsForFraud;
	}
	public void setSuspectsForFraud(HashSet<String> suspectsForFraud) {
		this.suspectsForFraud = suspectsForFraud;
	}

}
