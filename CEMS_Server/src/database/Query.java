package database;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.ExecutedTest;
import entities.Question;
import server.EchoServer;

public class Query {

	// Select from Table WHERE column=item
	public static ResultSet SelectTableWhere(String tableName, String column, String item) {
		return resultqueryFrom("SELECT * FROM `" + tableName + "` WHERE `" + column + "` = \"" + item + "\";");
	}
	// Select from Table WHERE condition
	public static ResultSet SelectTableWhereCondition(String tableName, String condition) {
		return resultqueryFrom("SELECT * FROM `" + tableName + "` WHERE `" + condition +";");
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


	





	

	public static ResultSet getActivatedTestByExecutionCode(String testExecCode) {
		return resultqueryFrom(
				"SELECT * FROM activatedtest WHERE code= \"" + testExecCode + "\";");
	}

	public static void InsertQuestionToDataBase(Question qst) {
			updateQuery("INSERT INTO `query`.`question` (`questionID`, `text`, `answers`, `correctAnswerIndex`, `composedBy`) "
				+ "VALUES ('"+qst.getQuestionID()+"', '"+qst.getText()+"', '"+qst.getAnswersString()+"', '"+qst.getCorrectAnswerIndex()+"', '"+qst.getTeacherComposed()+"');");
	}
	public static void IncreaseNumOfQuestionInCourse(String courseID) {
		updateQuery("UPDATE course SET numOfQuestions=numOfQuestions+1 WHERE ID= "+courseID+";");
	}
	
	public static void IncreaseNumOfTestInCourse(String courseID) {
		updateQuery("UPDATE course SET numOfTests=numOfTests+1 WHERE ID= "+courseID+";");
	}
	
	public static ResultSet SelectColumnTableWhere(String selColumn,String tableName,String column,String item) {
		return resultqueryFrom("SELECT "+selColumn+  " FROM `" + tableName + "` WHERE `" + column + "` = \"" + item + "\";");
	}

	public static ResultSet getEmailByComposerId(String composerId) {
		return resultqueryFrom("SELECT * FROM user WHERE personalSID = " + composerId + ";");

	}
	
	public static ResultSet getActivatedTestsByCode(String testCode) {
		return resultqueryFrom("SELECT * FROM activatedtest WHERE code = \"" + testCode + "\";");
	}

	public static String getFullNameByID(String personalID) throws SQLException {
		ResultSet rs = resultqueryFrom(
				"SELECT firstName, LastName FROM user WHERE personalSID = '" + personalID + "';");
		System.out.println(personalID);
		System.out.println(rs.getString(1) + " " + rs.getString(2));
		return rs.getString(1) + " " + rs.getString(2);
	}

	public static ResultSet countTableEntries(String tableName) {
		return resultqueryFrom("SELECT COUNT(*) FROM "+ tableName+";");
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

	public static ResultSet getAllExecutedTestsByCode(String testCode) {

		Connection con = SetConnectionDB.start();
		Statement stmt;
		ResultSet toReturn = null;
		try {
			stmt = con.createStatement();
			toReturn = stmt.executeQuery("SELECT * FROM executedtest WHERE TestCode= " + testCode + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	public static void writeManualTestBlobToDB(Blob b1, ExecutedTest excTest) {
		Connection con = SetConnectionDB.start();
		
		String studentID = excTest.getExecutedBy();
		String execCode = excTest.getExecutionCodePK();
		System.out.println(studentID + "" + execCode);
		String query = "UPDATE executedtest SET " + "uploadedmtest = ? " + "WHERE TestCode = ? " + "AND " + "ExecutedBy = ?" + ";";
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
	
	public static ResultSet getAllTestsActivatedByTeacherID(String teacherID) {
		Connection con = SetConnectionDB.start();
		Statement stmt;
		ResultSet toReturn = null;
		try {
			stmt = con.createStatement();
			toReturn = stmt.executeQuery("SELECT * FROM activatedtest WHERE activatedBy= \"" + teacherID + 
					"\"AND isActive = 0;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
		
	}
	
	public static ResultSet getAllExecutedTestsToConfirmByCode(String testCode) {
		Connection con = SetConnectionDB.start();
		Statement stmt;
		ResultSet toReturn = null;
		try {
			stmt = con.createStatement();
			toReturn = stmt.executeQuery("SELECT * FROM executedtest WHERE TestCode= " + testCode +
					" AND isGradeAuthorized = 0 "
					+ "AND TestCode IN (SELECT TestCode FROM executedtest "
					+ "GROUP BY TestCode HAVING count(*)>1);");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	public static int confirmAndChangeGrade(int newGrade, String executedBy, String testCode) {
		Connection con = SetConnectionDB.start();
		Statement stmt;
		int toReturn = 0;
		try {
			System.out.println(newGrade);
			stmt = con.createStatement();
			
			toReturn = stmt.executeUpdate("UPDATE executedtest SET Grade = " 
			+ newGrade + " WHERE testCode= \"" + testCode + "\" AND executedBy = \"" + executedBy + "\";");
			
			toReturn = stmt.executeUpdate("UPDATE executedtest SET isGradeAuthorized = 1"+ " WHERE testCode= \""
			+ testCode + "\" AND executedBy = \"" + executedBy + "\";");
			
			return toReturn;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	public static int updateIsAuthorized(String testCode, String executedBy) {
		Connection con = SetConnectionDB.start();
		Statement stmt;
		int toReturn = 0;
		try {
			stmt = con.createStatement();
			toReturn = stmt.executeUpdate("UPDATE executedtest SET isGradeAuthorized = 1"+ " WHERE testCode= \""
					+ testCode + "\" AND executedBy = \"" + executedBy + "\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	
	public static int updateIsSuspect(String testCode, String executedBy) {
		Connection con = SetConnectionDB.start();
		Statement stmt;
		int toReturn = 0;
		try {
			stmt = con.createStatement();
			toReturn = stmt.executeUpdate("UPDATE executedtest SET isSuspect = 1"+ " WHERE testCode= \""
					+ testCode + "\" AND executedBy = \"" + executedBy + "\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
		
	}
	
public static int updateIsActivated(String testCode) {
	Connection con = SetConnectionDB.start();
	Statement stmt;
	int toReturn = 0;
	try {
		stmt = con.createStatement();
		toReturn = stmt.executeUpdate("UPDATE activatedtest SET isActive = 0" + " WHERE code= \""
				+ testCode + "\";");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return toReturn;
	}
	
	public static ResultSet getLiveTestByExecutionCode(String testCode) {
		Connection con = SetConnectionDB.start();
		Statement stmt;
		ResultSet toReturn = null;
		try {
			stmt = con.createStatement();
			toReturn = stmt.executeQuery("SELECT * FROM activatedtest WHERE code= \"" + testCode + 
					"\"AND isActive = 1;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	//------------------------------------------------------------------------------------------------------
	


	// ------------------------------------------------------------------------------------------------------


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
			StatementOfResultSet.executeUpdate(query);
			// Resultset.next();
			// System.out.println(Resultset.getString(1));

		} catch (SQLException e) {
			EchoServer.SC.addToTextArea("ERROR--> geting data from server");
			e.printStackTrace();
		}
	}
	
	
	
	

	

}