package database;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.ExecutedTest;
import server.EchoServer;

public class Query {

	// Select from Table WHERE column=item
	public static ResultSet SelectTableWhere(String tableName, String column, String item) {
		return resultqueryFrom("SELECT * FROM `" + tableName + "` WHERE `" + column + "` = \"" + item + "\";");
	}

	// INSERT HERE MORE
	// QUERIES-----------------------------------------------------------------------------

	public static ResultSet getQuestionByID(String questionID) {
		return resultqueryFrom("SELECT * FROM question WHERE questionID= " + questionID + ";");
	}

	public static ResultSet getTestByExecutionCode(String testExecCode) {
		return resultqueryFrom(
				"SELECT * FROM test WHERE isActivated = true AND" + " currExecCode= \"" + testExecCode + "\";");
	}

	public static String getFullNameByID(String personalID) throws SQLException {
		ResultSet rs = resultqueryFrom(
				"SELECT firstName, LastName FROM user WHERE personalSID = '" + personalID + "';");
		System.out.println(personalID);
		System.out.println(rs.getString(1) + " " + rs.getString(2));
		return rs.getString(1) + " " + rs.getString(2);
	}

	public static ResultSet SelectFullTable(String tableName) {
		return resultqueryFrom("SELECT * FROM " + tableName);
	}

	public static ResultSet getTestListForTeacherFullTable() {
		return resultqueryFrom(
				"select test.testID, field.name as field, course.name as course , test.allocatedDuration, User.firstName, User.lastname\r\n"
						+ "from course, user , test,field,\r\n"
						+ "(Select SUBSTR(testid, 1, 2) as fieldID, SUBSTR(testid, 3,2) as courseID , testID from test) as IDS\r\n"
						+ "where course.ID=IDS.courseID and field.ID=IDS.fieldID and test.ComposedBy=user.personalSID and IDS.testID = test.testID");
	}

	public static ResultSet getReport(String query) {
		return resultqueryFrom(query);
	}

	public static void update(String query) {
		updateQuery(query);
	}

	public static ResultSet getExecutionCodesHistory() {

		Connection con = SetConnectionDB.start();
		Statement stmt;
		ResultSet toReturn = null;
		try {
			stmt = con.createStatement();
			toReturn = stmt.executeQuery("SELECT * FROM execodehistory;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
<<<<<<< HEAD
	
	public static void writeManualTestBlobToDB(Blob b1, ExecutedTest excTest) {
		Connection con = SetConnectionDB.start();
		
		String studentID = excTest.getExecutedBy();
		String execCode = excTest.getExecutionCodePK();
		String query = "UPDATE executedtest SET " + "SET uploadedmtest = ? " + "WHERE TestCode = ? " + "AND " + "ExecutedBy = ?" + ";";
		try {
			PreparedStatement toReturn = con.prepareStatement(query);
			toReturn.setBlob(1, b1);
			toReturn.setString(2, execCode);
			toReturn.setString(3, studentID);
			toReturn.executeUpdate();
			System.out.println("Stored the file in the BLOB column.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//------------------------------------------------------------------------------------------------------
	
=======

	// ------------------------------------------------------------------------------------------------------

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
	private static ResultSet resultqueryFrom(String query) {
		Connection connection = SetConnectionDB.start();
		Statement StatementOfResultSet;
		ResultSet Resultset;

		try {
			StatementOfResultSet = connection.createStatement();
			Resultset = StatementOfResultSet.executeQuery(query);
			// Resultset.next();
			// System.out.println(Resultset.getString(1));
			return Resultset;
		} catch (SQLException e) {
			EchoServer.SC.addToTextArea("ERROR--> geting data from server");
			e.printStackTrace();
		}
		return null;
	}

	private static void updateQuery(String query) {
		Connection connection = SetConnectionDB.start();
		Statement StatementOfResultSet;

		try {
			StatementOfResultSet = connection.createStatement();
			StatementOfResultSet.executeQuery(query);
			// Resultset.next();
			// System.out.println(Resultset.getString(1));

		} catch (SQLException e) {
			EchoServer.SC.addToTextArea("ERROR--> geting data from server");
			e.printStackTrace();
		}
	}

}