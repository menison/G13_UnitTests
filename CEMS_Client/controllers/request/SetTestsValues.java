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
}
