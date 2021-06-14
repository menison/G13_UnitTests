package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Operation;
import database.Query;
import entities.Message;
import entities.Question;
import entities.Test;

public class EditTest {
	public static Message getTest(Message msg){
		ResultSet rs;
		String ID= (String)msg.getObj();
		System.out.println(ID);
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
				ArrayList<Question> questionArray=new ArrayList<Question>();
				
				//	public Test(ArrayList<Question> questions, String testID, int allocatedDuration, String commentsForStudents,String commentsForTeachers, String currExecutionCode, String[] pointDistribution, String teacherComposed,String subject, String course, int isActivated) {
				//	public Test (String testID,String questionString,int allocatedDuration,String commentsForStudents,String commentsForTeachers,String currExecutionCode,String pointsString,int isActivated,String teacherComposed)
				System.out.println(rs.getString(1));
				
				Test test = new Test(testID, questions, allocatedDuration, commentsForStudents,commentsForTeachers ,currExecCode,pointDistribution,isActivated, ComposedBy);
				return new Message(Operation.GetTestByID,test);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Message(Operation.GetTestByID,null);

	}
}
