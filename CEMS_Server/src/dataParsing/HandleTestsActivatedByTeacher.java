package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Operation;
import database.Query;
import entities.ActivatedTest;
import entities.Message;

public class HandleTestsActivatedByTeacher {
	public static Message returnTestsByTeacher(Message msg){
		String TeacherID = (String)msg.getObj();
		ResultSet rs;
		ArrayList<ActivatedTest> testsByTeacher = new ArrayList<ActivatedTest>();

		rs=Query.getReport("SELECT * FROM activatedtest WHERE activatedBy = "+TeacherID+" and isActive = 1;");
		//	public ActivatedTest(String testCode, String testID, String activatedBy, String startDate, String startTime, int isActivated)
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Message(Operation.GetTestsActivatedByTeachger,testsByTeacher);
		
	}
}
