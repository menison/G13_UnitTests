package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.TestForFullTable;
import gui.ServerController;
import server.EchoServer;

public class Query {
	
	
	//Select from Table WHERE column=item
	public static ResultSet SelectTableWhere(String tableName, String column, String item) {
		return resultqueryFrom("SELECT * FROM `" + tableName + "` WHERE `" + column + "` = \"" + item + "\";");
	}
	
	//INSERT HERE MORE QUERIES-----------------------------------------------------------------------------
	
	//David
	
	
	public static String getFullNameByID(String personalID) throws SQLException {
		ResultSet rs = resultqueryFrom("SELECT firstName, LastName FROM user WHERE personalSID = '" + personalID + "';");
		System.out.println(personalID);
		System.out.println(rs.getString(1)+" "+rs.getString(2));
			return rs.getString(1)+" "+rs.getString(2);
	}
	
	
	public static ResultSet SelectFullTable(String tableName) {
		return resultqueryFrom("SELECT * FROM " + tableName );
	}
	public static ResultSet getTestListForTeacherFullTable() {
		return resultqueryFrom("select test.testID, field.name as field, course.name as course , test.allocatedDuration, User.firstName, User.lastname\r\n"
				+ "from course, user , test,field,\r\n"
				+ "(Select SUBSTR(testid, 1, 2) as fieldID, SUBSTR(testid, 3,2) as courseID , testID from test) as IDS\r\n"
				+ "where course.ID=IDS.courseID and field.ID=IDS.fieldID and test.ComposedBy=user.personalSID and IDS.testID = test.testID");
	}
	
	
	
	//------------------------------------------------------------------------------------------------------
	
	private static ResultSet resultqueryFrom(String query) {
		Connection connection = SetConnectionDB.start();
		Statement StatementOfResultSet;
		ResultSet Resultset;

		try {
			StatementOfResultSet = connection.createStatement();
			Resultset = StatementOfResultSet.executeQuery(query);
			//Resultset.next();
			//System.out.println(Resultset.getString(1));
			return Resultset;
		} catch (SQLException e) {
			EchoServer.SC.addToTextArea("ERROR--> geting data from server");
			e.printStackTrace();
		}
		return null;
	}
	

}
