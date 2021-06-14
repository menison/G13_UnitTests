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

/**Class that unifies all the queries that are used during the run of the system.
 * @author Aviv
 *
 */
public class Query {

	/**SELECT * FROM table WHERE column = item.
	 * @param tableName the table name in the database.
	 * @param column name of the column.
	 * @param item object for comparison.
	 * @return returns full row from the database .
	 */
	public static ResultSet SelectTableWhere(String tableName, String column, String item) {
		return resultqueryFrom("SELECT * FROM `" + tableName + "` WHERE `" + column + "` = \"" + item + "\";");
	}
	
	/**SELECT * FROM table WHERE condition has been met.
	 * @param tableName name of the table.
	 * @param condition the condition in which we invoke the query.
	 * @return returns full row from the database.
	 */
	public static ResultSet SelectTableWhereCondition(String tableName, String condition) {
		return resultqueryFrom("SELECT * FROM `" + tableName + "` WHERE `" + condition +";");
	}



	/**SELECT * FROM question WHERE questionID=ID.
	 * @param questionID the question id.
	 * @return returns row from question table with the specific id.
	 */
	public static ResultSet getQuestionByID(String questionID) {
		return resultqueryFrom("SELECT * FROM question WHERE questionID= " + questionID + ";");
	}

	/**SELECT * FROM test WHERE isActivated=true AND currEcecCode=test execution code.
	 * @param testExecCode test execution code.
	 * @return returns row of test from the database in which the test is currently active and with the specific test execution code.
	 */
	public static ResultSet getTestByExecutionCode(String testExecCode) {
		return resultqueryFrom(
				"SELECT * FROM test WHERE isActivated = true AND" + " currExecCode= \"" + testExecCode + "\";");
	}


	






	public static ResultSet getExecutedTestByCodeAndID(String testExecCode,String userID) {
		return resultqueryFrom(
				"SELECT * FROM executedtest WHERE TestCode= \"" + testExecCode + "\" AND "
						+ "ExecutedBy = \"" + userID +"\";");
	}


	/**SELECT * FROM activatedtest where code=test execution code.
	 * @param testExecCode test execution code.
	 * @return row of activated test with the specific test execution code.
	 */

	public static ResultSet getActivatedTestByExecutionCode(String testExecCode) {
		return resultqueryFrom(
				"SELECT * FROM activatedtest WHERE code= \"" + testExecCode + "\";");
	}

	/**Inserts a question into the database.
	 * @param qst the question which is need to be inserted.
	 */
	public static void InsertQuestionToDataBase(Question qst) {
			updateQuery("INSERT INTO `query`.`question` (`questionID`, `text`, `answers`, `correctAnswerIndex`, `composedBy`) "
				+ "VALUES ('"+qst.getQuestionID()+"', '"+qst.getText()+"', '"+qst.getAnswersString()+"', '"+qst.getCorrectAnswerIndex()+"', '"+qst.getTeacherComposed()+"');");
	}
	/**Increase the amount of questions for the specific field in the database.
	 * @param fieldID the field ID.
	 */
	public static void IncreaseNumOfQuestionInField(String fieldID) {
		updateQuery("UPDATE field SET numOfQuestions=numOfQuestions+1 WHERE ID= "+fieldID+";");
	}
	
	public static void IncreaseNumOfTestInCourse(String courseID) {
		updateQuery("UPDATE course SET numOfTests=numOfTests+1 WHERE ID= "+courseID+";");
	}
	
	/**SELECT selected column FROM table name WHERE column=item.
	 * @param selColumn column for selection.
	 * @param tableName table name.
	 * @param column column for comparison.
	 * @param item object for comparison with.
	 * @return
	 */
	public static ResultSet SelectColumnTableWhere(String selColumn,String tableName,String column,String item) {
		return resultqueryFrom("SELECT "+selColumn+  " FROM `" + tableName + "` WHERE `" + column + "` = \"" + item + "\";");
	}

	/**get email by the composer id from the database
	 * @param composerId composer's id
	 * @return row of user from the database.
	 */
	public static ResultSet getEmailByComposerId(String composerId) {
		return resultqueryFrom("SELECT * FROM user WHERE personalSID = " + composerId + ";");

	}
	
	/**get an activated test from the database.
	 * @param testCode test execution code.
	 * @return returns a row of activated test from the database.
	 */
	public static ResultSet getActivatedTestsByCode(String testCode) {
		return resultqueryFrom("SELECT * FROM activatedtest WHERE code = \"" + testCode + "\";");
	}

	/**get user name by his id from the database.
	 * @param personalID the user's id.
	 * @return  returns users full name (first name and last name).
	 * @throws SQLException Exception in case didnt managed to connect to the database.
	 */
	public static String getFullNameByID(String personalID) throws SQLException {
		ResultSet rs = resultqueryFrom(
				"SELECT firstName, LastName FROM user WHERE personalSID = '" + personalID + "';");
		System.out.println(personalID);
		System.out.println(rs.getString(1) + " " + rs.getString(2));
		return rs.getString(1) + " " + rs.getString(2);
	}

	/**count the table entries of a specific table.
	 * @param tableName the table name.
	 * @return returns how many entries there are in the table.
	 */
	public static ResultSet countTableEntries(String tableName) {
		return resultqueryFrom("SELECT COUNT(*) FROM "+ tableName+";");
	}
	
	/**get full table from the database.
	 * @param tableName table name.
	 * @return returns the full table from the database.
	 */
	public static ResultSet SelectFullTable(String tableName) {
		return resultqueryFrom("SELECT * FROM " + tableName);
	}

	/**get the list of test that are composed by the current user.
	 * @return all the test that are composed by the current user.
	 */
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

	/**get the execution code history table.
	 * @return full execodehistory table.
	 */
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

	/**get an executed test with the specific test code.
	 * @param testCode test execution code.
	 * @return row from the executed test table.
	 */
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
	
	/**Write a manual test for the DB.
	 * @param b1 blob for the manual test.
	 * @param excTest executed test.
	 */
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
	
	/**Get all the tests that are activated by the teacher id.
	 * @param teacherID Teacher personal ID.
	 * @return get all the tests that activated by the desired teacher ID.
	 */
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
	
	/**Get all the executed test that are waiting for the teacher's confirmation.
	 * @param testCode test execution code.
	 * @return return the executed tests that are waiting for the teacher's confirmation.
	 */
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
	
	/**Confirm and change for the new grade for an executed test.
	 * @param newGrade New grade.
	 * @param executedBy test executed by.
	 * @param testCode test execution code.
	 * @return
	 */
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
	
	/**Authorize the grade of a specific test.
	 * @param testCode test execution code.
	 * @param executedBy id of the person who executed the test.
	 * @return authorize a grade for a specific test.
	 */
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
	
	
	/**Update a test to be suspect for copying.
	 * @param testCode test execution code.
	 * @param executedBy id of the user who executed the test.
	 * @return
	 */
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

	
/**Update a test to be inactive.
 * @param testCode test execution code.
 * @return
 */
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
	
	/**Get a specific active test from the database.
	 * @param testCode test execution code.
	 * @return
	 */
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



	/**Method for running resultSet queries (SELECT) while connecting to the database using the setConnectionDB method.
	 * @param query the query which is needed for running.
	 * @return
	 */
	private static ResultSet resultqueryFrom(String query) {
		Connection connection = SetConnectionDB.start();
		Statement StatementOfResultSet;
		ResultSet Resultset;

		try {
			StatementOfResultSet = connection.createStatement();
			Resultset = StatementOfResultSet.executeQuery(query);
			return Resultset;
		} catch (SQLException e) {
			EchoServer.SC.addToTextArea("ERROR--> geting data from server");
			e.printStackTrace();
		}
		return null;
	}

	/**Method for running all the INSERT and UPDATE queries while connecting to the database using the setConnectionDB mothod.
	 * @param query the query which is needed for running.
	 */
	private static void updateQuery(String query) {
		Connection connection = SetConnectionDB.start();
		Statement StatementOfResultSet;

		try {
			StatementOfResultSet = connection.createStatement();
			StatementOfResultSet.executeUpdate(query);


		} catch (SQLException e) {
			EchoServer.SC.addToTextArea("ERROR--> geting data from server");
			e.printStackTrace();
		}
	}
	
	
	
	

	

}