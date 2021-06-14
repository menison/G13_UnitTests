package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Operation;
import database.Query;
import entities.Message;
import entities.TestToConfirm;

public class GetTestConfirmationTable {

	/**
	 * @param receivedMessage
	 * @return
	 */
	public static Message get(Message receivedMessage) {
		Message messageToReturn;
		ArrayList<TestToConfirm> testList;
		ArrayList<String> testCodes;
		testCodes = new ArrayList<>();
		testList = new ArrayList<>();
		String teacherID = (String) receivedMessage.getObj();
		TestToConfirm t = null;
		ResultSet rs = Query.getAllTestsActivatedByTeacherID(teacherID);
		try {
			while (rs.next())
				testCodes.add(rs.getString(1));
			
			for (int i = 0; i < testCodes.size(); i++) {
				rs = Query.getAllExecutedTestsToConfirmByCode(testCodes.get(i));
				while (rs.next()) {
					String testID = rs.getString(1);
					String testCode = testCodes.get(i);
					String date = rs.getString(4);
					String executedBy = rs.getString(3);
					int grade = rs.getInt(7);
					int isSuspect = rs.getInt(12);
					t = new TestToConfirm(testID, testCode, date, executedBy, grade, isSuspect);
					testList.add(t);
				}
				
			}
			if(testList.size() == 0)
				return new Message(Operation.GetTestTable,null);
			
			System.out.println("Success setting table");
			rs.close();
			
			messageToReturn = new Message(Operation.GetTestConfirmationTable,testList);
			return messageToReturn;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}
}
