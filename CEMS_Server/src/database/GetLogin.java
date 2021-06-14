package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Operation;
import common.Permission;
import entities.Message;
import entities.Principal;
import entities.Student;
import entities.Teacher;
import gui.ServerController;
import logics.DataParsing;
import server.EchoServer;

/**Method for classifying user type from the request of the client, including a logout method.
 * @author Aviv
 *
 */
public class GetLogin {
	
	
	/**ArrayList of type String of all the users that are currently logged into the system.
	 * 
	 */
	public static ArrayList<String> usersloggedIn = new ArrayList<String>();
	/**ResultSet for running queries.
	 * 
	 */
	public static ResultSet resultSet;
	/**
	 * Data that includes user name and password that are inserted by the client.
	 */
	public static ArrayList<String> Data;
	

	/**Method for classifying the type of user that is trying to log in.
	 * @param object Contains the data of the user - user name and password.
	 * @return Message with the current permission of the user (yes,no,NULL) and his details.
	 */
	@SuppressWarnings("unchecked")
	public static Message userLoginData(Message object) {
		Data = (ArrayList<String>) object.getObj();
		resultSet = Query.SelectTableWhere("user", "username", Data.get(0));
		Message returnMessage;
		try {
		if(!resultSet.next()) {
			returnMessage=new Message(Operation.Login,Permission.NULL);
		}
		else {
			switch(resultSet.getString(7)) {
			case "Student":
				returnMessage=studentLoginData();
				break;
			case "Teacher":
				returnMessage=teacherLoginData();
				break;
			case "Principal":
				returnMessage=principalLoginData();
				break;
			default:
				returnMessage=null;	
			}
		}
		return returnMessage;
		}catch(SQLException e) {
			EchoServer.SC.addToTextArea("Error while getting data from server");
		}
		return null;
	}
	
	/**Method of adding teacher to the connected users arraylist and defining the user permission.
	 * @return Message with the user permission and his details.
	 * @throws SQLException In case didn't managed to log into the database.
	 */
	public static Message teacherLoginData() throws SQLException {
		Teacher teacher;
		Message returnMessage;
		teacher=new Teacher(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)
				,resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
		resultSet.close();
		if(usersloggedIn.contains(teacher.getPersonalSID())) {
			return new Message(Operation.Login,Permission.AlreadyLoggedIn);
		}
		
		returnMessage=new Message(Operation.Login,teacher);
		returnMessage.setPermission(DataParsing.getPermission(teacher.getPassword(), Data.get(1)));
		if(returnMessage.getPermission().equals(Permission.yes)) {
			usersloggedIn.add(teacher.getPersonalSID());
			ServerController.sc.addToTextArea(teacher.getFirstName()+" the "+teacher.getRole()+" connected to the server");
		}
		else
			ServerController.sc.addToTextArea(teacher.getFirstName()+" failed to connect to the server");
		return returnMessage;
	}
	
	/**Method of adding student to the connected users arraylist and defining the user permission.
	 * @return Message with the user permission and his details.
	 * @throws SQLException In case didn't managed to log into the database.
	 */
	public static Message studentLoginData() throws SQLException {
		Student student;
		Message returnMessage;
		student=new Student(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)
				,resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
		resultSet.close();
		if(usersloggedIn.contains(student.getPersonalSID())) {
			return new Message(Operation.Login,Permission.AlreadyLoggedIn);
		}
		
		returnMessage=new Message(Operation.Login,student);
		returnMessage.setPermission(DataParsing.getPermission(student.getPassword(), Data.get(1)));
		if(returnMessage.getPermission().equals(Permission.yes)) {
			ServerController.sc.addToTextArea(student.getFirstName()+" the "+student.getRole()+" connected to the server");
			usersloggedIn.add(student.getPersonalSID());
		}
		else
			ServerController.sc.addToTextArea(student.getFirstName()+" failed to connect to the server");
		return returnMessage;
	}
	
	/**Method of adding student to the connected users arraylist and defining the user permission
	 * @return Message with the user permission and his details.
	 * @throws SQLException In case didn't managed to log into the database.
	 */
	public static Message principalLoginData() throws SQLException {
		Principal principal;
		Message returnMessage;
		principal=new Principal(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)
				,resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
		resultSet.close();
		if(usersloggedIn.contains(principal.getPersonalSID())) {
			return new Message(Operation.Login,Permission.AlreadyLoggedIn);
		}
		
		returnMessage=new Message(Operation.Login,principal);
		returnMessage.setPermission(DataParsing.getPermission(principal.getPassword(), Data.get(1)));
		if(returnMessage.getPermission().equals(Permission.yes)) {
			ServerController.sc.addToTextArea(principal.getFirstName()+" the "+principal.getRole()+" connected to the server");
			usersloggedIn.add(principal.getPersonalSID());
		}
		else
			ServerController.sc.addToTextArea(principal.getFirstName()+" failed to connect to the server");
		return returnMessage;
	}
	
	/**Log out method for removing a user from the connected users array list by using his ID.
	 * @param msg Message that contains the specific user details.
	 * @return Return message for the client with the use id and operation type (Logout).
	 */
	public static Message logOut(Message msg) {
		String id=(String)msg.getObj();
		usersloggedIn.remove(id);
		return new Message(Operation.Logout,id);
	}
	
	

}
