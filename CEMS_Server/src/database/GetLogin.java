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

public class GetLogin {
	
	public static ArrayList<String> usersloggedIn = new ArrayList<String>();
	public static ResultSet resultSet;
	public static ArrayList<String> Data;
	
	//differentiate between the type of users
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
	
	public static Message teacherLoginData() throws SQLException {
		Teacher teacher;
		Message returnMessage;
		teacher=new Teacher(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)
				,resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
		resultSet.close();
		if(usersloggedIn.contains(teacher.getPersonalSID())) {
			return new Message(Operation.Login,Permission.AlreadyLoggedIn);
		}
		usersloggedIn.add(teacher.getPersonalSID());
		returnMessage=new Message(Operation.Login,teacher);
		returnMessage.setPermission(DataParsing.getPermission(teacher.getPassword(), Data.get(1)));
		if(returnMessage.getPermission().equals(Permission.yes))
			ServerController.sc.addToTextArea(teacher.getFirstName()+" the "+teacher.getRole()+" connected to the server");
		else
			ServerController.sc.addToTextArea(teacher.getFirstName()+" failed to connect to the server");
		return returnMessage;
	}
	
	public static Message studentLoginData() throws SQLException {
		Student student;
		Message returnMessage;
		student=new Student(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)
				,resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
		resultSet.close();
		if(usersloggedIn.contains(student.getPersonalSID())) {
			return new Message(Operation.Login,Permission.AlreadyLoggedIn);
		}
		usersloggedIn.add(student.getPersonalSID());
		returnMessage=new Message(Operation.Login,student);
		returnMessage.setPermission(DataParsing.getPermission(student.getPassword(), Data.get(1)));
		if(returnMessage.getPermission().equals(Permission.yes))
			ServerController.sc.addToTextArea(student.getFirstName()+" the "+student.getRole()+" connected to the server");
		else
			ServerController.sc.addToTextArea(student.getFirstName()+" failed to connect to the server");
		return returnMessage;
	}
	
	public static Message principalLoginData() throws SQLException {
		Principal principal;
		Message returnMessage;
		principal=new Principal(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)
				,resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
		resultSet.close();
		if(usersloggedIn.contains(principal.getPersonalSID())) {
			return new Message(Operation.Login,Permission.AlreadyLoggedIn);
		}
		usersloggedIn.add(principal.getPersonalSID());
		returnMessage=new Message(Operation.Login,principal);
		returnMessage.setPermission(DataParsing.getPermission(principal.getPassword(), Data.get(1)));
		if(returnMessage.getPermission().equals(Permission.yes))
			ServerController.sc.addToTextArea(principal.getFirstName()+" the "+principal.getRole()+" connected to the server");
		else
			ServerController.sc.addToTextArea(principal.getFirstName()+" failed to connect to the server");
		return returnMessage;
	}
	
	public static Message logOut(Message msg) {
		String id=(String)msg.getObj();
		usersloggedIn.remove(id);
		return new Message(Operation.Logout,id);
	}
	
	

}
