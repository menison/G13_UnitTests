package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import server.EchoServer;


/**Singleton for setting a connection to the database using the schema's name and the password.
 * @author Aviv
 *
 */
public class SetConnectionDB {
	/**
	 * setConnectionDB singleton instance.
	 */
	private static SetConnectionDB instance = null;
	/**The Connection
	 * 
	 */
	private Connection conn = null;

<<<<<<< HEAD
	public static String DBhost = "localhost";

//	public static String DBname = "query";
//	public static String DBPassword = "sa1993sha";


//	public static String DBname = "test";
//	public static String DBPassword = "2694";
=======
	/**
	 * Database host name.
	 */
	public static String DBhost = "localhost";
	public static String DBname = "query";
	public static String DBPassword = "sa1993sha";
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git

	public static String DBuser = "root";

	private SetConnectionDB() {
		this.conn = setConnection();
	}

	/**Method for setting the connection to the database.
	 * @return returns the connection to the database.
	 */
	private Connection setConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			EchoServer.SC.addToTextArea("Driver definition succeed");
		} catch (Exception ex) {
			ex.printStackTrace();
			EchoServer.SC.addToTextArea("Driver definition failed");
		}
		try {
			Connection con = DriverManager
					.getConnection("jdbc:mysql://" + DBhost + "/" + DBname + "?serverTimezone=CAT", DBuser, DBPassword);
			EchoServer.SC.addToTextArea("SQL connection succeed");
			return con;
		} catch (SQLException ex) {/* handle any errors */
			EchoServer.SC.addToTextArea("SQLException: " + ex.getMessage());
			EchoServer.SC.addToTextArea("SQLState: " + ex.getSQLState());
			EchoServer.SC.addToTextArea("VendorError: " + ex.getErrorCode());

		}
		return null;
	}

	/**Start the connection.
	 * @return
	 */
	public static Connection start() {
		if (instance == null) {
			instance = new SetConnectionDB();
			return instance.conn;
		}
		return instance.conn;
	}
}