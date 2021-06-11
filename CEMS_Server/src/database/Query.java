package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import server.EchoServer;

public class Query {
	
	
	//Select from Table WHERE column=item
	public static ResultSet SelectTableWhere(String tableName, String column, String item) {
		return resultqueryFrom("SELECT * FROM `" + tableName + "` WHERE `" + column + "` = \"" + item + "\";");
	}
	
	//INSERT HERE MORE QUERIES-----------------------------------------------------------------------------
	
	public static ResultSet getQuestionByID(String questionID) {
		Connection con = SetConnectionDB.start();
		Statement stmt;
		ResultSet toReturn = null;
		try {
			stmt = con.createStatement();
			toReturn = stmt.executeQuery("SELECT * FROM question WHERE questionID= " 
			+ questionID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	public static ResultSet getTestByExecutionCode(String testExecCode) {
		Connection con = SetConnectionDB.start();
		Statement stmt;
		ResultSet toReturn = null;
		try {
			stmt = con.createStatement();
			toReturn = stmt.executeQuery("SELECT * FROM test WHERE isActivated = true AND"
					+ " currExecutionCode= " + testExecCode + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	
	public static String getFullNameByID(String personalID) throws SQLException {
		ResultSet rs = resultqueryFrom("SELECT firstName, LastName FROM User WHERE personalSID = '"+personalID+"'");
			return rs.getString(1)+" "+rs.getString(2);
	}
	
	
	public static ResultSet SelectFullTable(String tableName) {
		return resultqueryFrom("SELECT * FROM" + tableName );
	}
	
	public static ResultSet principalGetReport(String query) {
		return resultqueryFrom(query);
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
	

}
