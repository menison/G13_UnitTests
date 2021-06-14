package dataParsing;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import common.Operation;
import database.SetConnectionDB;
import entities.ExecutedTest;
import entities.Message;

public class SetCompletedStudentExam {
	
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
