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
import gui.ServerController;

public class AddTestsOperations {
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
				for(String s: rs.getString(3).split(",")) {
					query1 = "SELECT name FROM course WHERE ID = " + s +";";
					rs1 = Query.getReport(query1);
					rs1.next();
					Course c = new Course(s,rs1.getString(1));
					courseList.add(c);
				}
				Field field = new Field(rs.getString(1),rs.getString(2),courseList);
				fields.add(field);
			}
			rs.close();
			messageToReturn = new Message(Operation.GetSubjectsAndCourses,fields);
			return messageToReturn;
		} catch	(SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}	
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
				Question question = new Question(rs.getString(1),rs.getString(2),rs.getString(3).split(","),rs.getInt(4),rs.getString(5));
				questions.add(question);
			}
			rs.close();
			messageToReturn = new Message(Operation.GetQuestions,questions);
			return messageToReturn;
		} catch	(SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}

}
