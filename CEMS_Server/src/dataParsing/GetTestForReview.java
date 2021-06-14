package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Operation;
import database.Query;
import entities.Message;
import entities.QaForTable;
import entities.TestForRequestedTest;

public class GetTestForReview {
	
	public static Message getTest(Message object) {
		ResultSet rs;
		ArrayList<QaForTable> qaList = new ArrayList<QaForTable>();
		QaForTable q;
		String[] str = new String[2];
		String[] ansArr = new String[4];
		String recivedMsg = (String)object.getObj();
		str = recivedMsg.split(",");
		String testCode = str[0];
		String userID = str[1];
		TestForRequestedTest t = null;
		rs = Query.getExecutedTestByCodeAndID(testCode, userID);
		try {
			rs.next();
			String answers = rs.getString(10);
			ansArr = answers.split(",");
			for(int i = 0; i < 4; i++) {
				q = new QaForTable("Question #" + (i+1),Integer.parseInt(ansArr[i]));
				qaList.add(q);
			}
			t = new TestForRequestedTest(rs.getString(1),rs.getString(2),
					rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),qaList);
		} catch (SQLException e) {}
		return new Message(Operation.GetTestForReview,t);
	}
}
