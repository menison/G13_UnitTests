package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Operation;
import database.Query;
import entities.ActivatedTest;
import entities.Message;

/**Class HandleTestsActivatedByTeacher
 * @author David
 * This class is to return tests activated by current user (teacher) 
 */
public class HandleTestsActivatedByTeacher {
	/**
	 * This method returns list of activated tests by current user
	 * @param msg				Holds String with teacher ID
	 * @param testsByTeacher	ArrayList to hold all activated tests by current user (teacher)
	 * @param rs				ResultSet to gets all activated test by current user
	 * @param testcode			Activated test code	
	 * @param testID			Activated test testID
	 * @param activatedBy		ID of user that activated test
	 * @param startDate			start date of test execution
	 * @param startTime			start time of test execution
	 * @param isACtivated		Is test activated it is used here mainly for the constructor, since only
	 * 							activatedTests with isActivate = 1 are received from SQL server 
	 * @param duration			duration of exam
	 * @return				returns an Array list of Activated tests in a message to the client 
	 * 
	 * 
	 */
	public static Message returnTestsByTeacher(Message msg){
		String TeacherID = (String)msg.getObj();
		ResultSet rs;
		ArrayList<ActivatedTest> testsByTeacher = new ArrayList<ActivatedTest>();

		rs=Query.getReport("SELECT * FROM activatedtest WHERE activatedBy = "+TeacherID+" and isActive = 1;");
		try {
			while(rs.next()){
				String testcode=rs.getString(1);
				String testID=rs.getString(2);
				String activatedBy =rs.getString(3);
				String startDate =rs.getString(4);
				String startTime =rs.getString(5);
				int isACtivated = rs.getInt(6);
				int duration = rs.getInt(9);
				testsByTeacher.add(new ActivatedTest(testcode, testID, activatedBy, startDate, startTime, isACtivated, duration));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return new Message(Operation.GetTestsActivatedByTeachger,testsByTeacher);
		
	}
}
