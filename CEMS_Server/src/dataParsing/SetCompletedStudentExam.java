package dataParsing;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import common.Operation;
import database.SetConnectionDB;
import entities.ExecutedTest;
import entities.Message;

/**
 * This class is responsible for updating DB with executed test data that was retrieved 
 * from the user during his test execution session.
 */
public class SetCompletedStudentExam {
	
	/**
	 * This method is responsible for writing the executedtest data to the DB,
	 * after the test's execution has completed.
	 * @param object
	 * @return Message containing the exams.
	 */
	public static Message setExam(Message object) {
		ExecutedTest e = (ExecutedTest)object.getObj();
		Connection con = SetConnectionDB.start();
		String testID = e.getTest().testID;
		String testCode = e.getExecutionCodePK();
		String executedBy = e.getExecutedBy();
		String date = e.getDate();
		int allocatedDuration = e.getTest().getAllocatedDuration();
		int actualDuration = e.getActualDuration();
		int grade = e.getGrade();
		String composedBy = e.getComposedBy();
		String answers = Arrays.toString(e.getAnswers());
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO executedtest VALUES (" + "'"+testID+"',"+"'"+testCode+"',"+
					"'"+executedBy+"',"+"'"+date+"',"+allocatedDuration+","+actualDuration+","+
					grade+","+"'"+composedBy+"',"+
					"'NULL',"+"'"+answers+"',"+"0,0);");
			stmt = con.createStatement();
			stmt.executeUpdate("UPDATE activatedtest SET howManyFinished = howManyFinished + 1 "
					+ "WHERE code = \"" + testCode + "\";");
		} catch (SQLException e1) {}
		return new Message(Operation.SetCompletedExam);
	}
}
