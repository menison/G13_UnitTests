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
	
	
	
	
	public static String getFullNameByID(String personalID) throws SQLException {
		ResultSet rs = resultqueryFrom("SELECT firstName, LastName FROM User WHERE personalSID = '"+personalID+"'");
			return rs.getString(1)+" "+rs.getString(2);
	}
	
	
	public static ResultSet SelectFullTable(String tableName) {
		return resultqueryFrom("SELECT * FROM" + tableName );
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
