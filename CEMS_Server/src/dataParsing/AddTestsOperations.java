package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Operation;
import database.Query;
import entities.Course;
import entities.Field;
import entities.Message;
import entities.Question;
import entities.Test;
import gui.ServerController;

/**Class for adding test into the database after getting it from the client side.
 * @author Aviv
 *
 */
public class AddTestsOperations {
	/**Method for getting the field and courses from the database for sending them to the client and store them in the data cache.
	 * @param msg Message with the operation name.
	 * @return returns a message with the operation name and the field array.
	 */
	public static Message getSubjectsAndCourses(Message msg) {
		ArrayList<Field> fields = new ArrayList<Field>();
		String query = null;
		String query1 = null;
		query = "SELECT * FROM field;";
		ResultSet rs;
		ResultSet rs1;
		Message messageToReturn;
		try {
			rs = Query.getReport(query);
			ServerController.sc.addToTextArea("Fetching Subjects");
			while (rs.next()) {
				ArrayList<Course> courseList = new ArrayList<Course>();
				for (String s : rs.getString(3).split(",")) {
					query1 = "SELECT name FROM course WHERE ID = " + s + ";";
					rs1 = Query.getReport(query1);
					rs1.next();
					Course c = new Course(s, rs1.getString(1));
					courseList.add(c);
				}
				Field field = new Field(rs.getString(1), rs.getString(2), courseList);
				fields.add(field);
			}
			rs.close();
			messageToReturn = new Message(Operation.GetSubjectsAndCourses, fields);
			return messageToReturn;
		} catch (SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}

	/**Method for getting all the questions in the database in order to store them in the data chache on the client side.
	 * @param msg a message containing the operation name 'GetQuestions'
	 * @return returns a message with the operation name and the questions array list.
	 */
	public static Message getQuestions(Message msg) {
		ArrayList<Question> questions = new ArrayList<Question>();
		String query = null;
		query = "SELECT * FROM question;";
		ResultSet rs;
		Message messageToReturn;
		try {
			rs = Query.getReport(query);
			ServerController.sc.addToTextArea("Fetching questions");
			while (rs.next()) {
				Question question = new Question(rs.getString(1), rs.getString(2), rs.getString(3).split(","),
						rs.getInt(4), rs.getString(5));
				questions.add(question);
			}
			rs.close();
			messageToReturn = new Message(Operation.GetQuestions, questions);
			return messageToReturn;
		} catch (SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}

	/**Method for getting amount of tests related to a specific course id.
	 * @param courseID course ID.
	 * @return returns the amount of related questions.
	 */
	public static int getAmountOfTests(String courseID) {
		Integer amountOfTests;
		String query = null;
		query = "SELECT numOfTests FROM course WHERE ID = " + courseID + ";";
		ResultSet rs;
		try {
			rs = Query.getReport(query);
			ServerController.sc.addToTextArea("Coounting Tests");
			rs.next();
			amountOfTests = rs.getInt(1);
			rs.close();
			return amountOfTests;
		} catch (SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return 0;
	}

	/**Method for adding a test to the database.
	 * @param msg message from the client containing the operation name and the test entity.
	 * @return returns a message with the operaion name and a confirmation message.
	 */
	public static Message addTest(Message msg) {
		Test test = (Test) msg.getObj();
		int amountOfTests = getAmountOfTests(test.getTestID());
		String newTestID;
		amountOfTests++;
		String fieldID="";
		ResultSet rs;
		try {
			rs=Query.SelectColumnTableWhere("belongsToField", "course", "ID", test.getTestID());
			rs.next();
			fieldID=rs.getString(1);
			rs.close();
		}catch(SQLException e) {
			System.out.println("Error getting data from server");
			e.printStackTrace();
		}
		if(amountOfTests<10) {
			newTestID=fieldID+test.getTestID()+"0"+Integer.toString(amountOfTests);
		}
		else {
			newTestID=fieldID+test.getTestID()+Integer.toString(amountOfTests);
		}
		Query.IncreaseNumOfTestInCourse(test.getTestID());
		test.setTestID(newTestID);
		Query.update(
				"INSERT INTO test (`testID`, `questions`, `allocatedDuration`, `commentsForStudents`, `commentsForTeachers`, `currExecCode`, `pointDistribution`, `isActivated`, `ComposedBy`) "
						+ "VALUES ('" + test.getTestID() + "', '" + test.getQuestionIDString() + "', "
						+ test.getAllocatedDuration() + ", '" + test.getCommentsForStudents() + "', '"
						+ test.getCommentsForTeachers() + "', '" + test.getCurrExecutionCode() + "', '"
						+ test.getPointsString() + "', " + test.isActivated() + ", '" + test.getComposedBy() + "');");
		ServerController.sc.addToTextArea("test ID:" + test.getTestID() + " was added");
		
		return new Message(Operation.AddNewTest, "Added new test successfully");
	}

	/**Method for increasing the amount of test related to the specific field by 1.
	 * @param msg Message containing the operation name, the current amount and the course ID.
	 * @return returns message with the operation name and a confirmation message.
	 */
	public static Message changeAmountOfTestsInCourseTable(Message msg) {
		String courseID = ((String) msg.getObj()).split("_")[0];
		String amount = ((String) msg.getObj()).split("_")[1];
		Query.update("UPDATE `query`.`course` SET `numOfTests` = '" + amount + "' WHERE (`ID` = '" + courseID + "');");
		ServerController.sc.addToTextArea("Number of test for course" + courseID + "is updated to " + amount);
		return new Message(Operation.ChangeAmountOfTestsInCourseTable, "Number of test for course changed");
	}
}
