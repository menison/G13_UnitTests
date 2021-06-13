package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.Course;
import entities.Field;
import entities.Message;
import entities.Question;
@SuppressWarnings("unchecked")
public class SetTestsValues {

	public static void setSubjects(Message receivedMessage) {
		ArrayList<Field> fields = (ArrayList<Field>) receivedMessage.getObj();
		DataManager.getDataManager().setFields(fields);
	}
	public static void setCourses(Message receivedMessage) {
		ArrayList<Course> courses = (ArrayList<Course>) receivedMessage.getObj();
		DataManager.getDataManager().setCourses(courses);
	}
	public static void setQuestions(Message receivedMessage) {
		ArrayList<Question> questions = (ArrayList<Question>) receivedMessage.getObj();
		DataManager.getDataManager().setQuestions(questions);
	}
	public static void setAmountOfTests(Message receivedMessage) {
		String amountOfTests = (String) receivedMessage.getObj();
		DataManager.getDataManager().setTestID(amountOfTests);
	}
	public static void addNewTest(Message receivedMessage) {
		String msg = (String) receivedMessage.getObj();
		DataManager.getDataManager().setAddTestMsg(msg);
	}
	public static void changeAmountOfTestsInCourseTable(Message receivedMessage) {
		String msg = (String) receivedMessage.getObj();
		DataManager.getDataManager().setAddTestMsg(msg);
	}
}
