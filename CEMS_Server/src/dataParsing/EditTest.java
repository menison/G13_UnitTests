package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Operation;
import database.Query;
import entities.Message;
import entities.Question;
import entities.Test;

/**Class EditTest 
 * @author David
 *this class handles requests from client for editing test
 */
public class EditTest {
	/**
	 * @param msg			contains message of String with test ID
	 * @param rs			ResultSet that holds a test from SQL
	 * @return 				return Test object
	 * this method receives test ID as a parameter finds a test with that id and returns it to client
	 */
	public static Message getTest(Message msg){
		ResultSet rs;
		String ID= (String)msg.getObj();

		rs=Query.getReport("SELECT * FROM test WHERE testID = "+ID);
		
		try {
			if(rs.next()) {
				String testID= rs.getString(1);
				String questions = rs.getString(2);
				int allocatedDuration = rs.getInt(3);
				String commentsForStudents = rs.getString(4);
				String commentsForTeachers = rs.getString(5);
				String currExecCode = rs.getString(6);
				String pointDistribution  = rs.getString(7);
				int isActivated = rs.getInt(8);
				String ComposedBy = rs.getString(9);

				
				
				Test test = new Test(testID, questions, allocatedDuration, commentsForStudents,commentsForTeachers ,currExecCode,pointDistribution,isActivated, ComposedBy);
				return new Message(Operation.GetTestByID,test);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Message(Operation.GetTestByID,null);

	}
	
	/**
	 * @param msg			message holds Test object for update
	 * @return				returns success message
	 * this method updates a certain test according to the test that was passed through msg parameter
	 */
	public static Message updateTest(Message msg){
		Test test =(Test)msg.getObj();
		Query.update("UPDATE test SET questions  = '"+test.getQuestionString()+"', allocatedDuration = '"+test.getAllocatedDuration()+"'"
				+ ", commentsForStudents  = '"+test.getCommentsForStudents()+"', commentsForTeachers = '"+test.getCommentsForTeachers()+"', pointDistribution  = '"+test.getPointsString()+"', ComposedBy = '"+test.getComposedBy()+"' WHERE testID = '"+test.getTestID()+"';");
		return new Message(Operation.UpdateTest,"Test updated susccessfully");
		
	}
}
