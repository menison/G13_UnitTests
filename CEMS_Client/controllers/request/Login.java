package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import entities.Teacher;
import gui.LoginCemsController;
import entities.Student;
import entities.Principal;
import javafx.event.ActionEvent;

/**
 * @author avivs100 A department whose job it is to send to the server the login
 *         details of the visitor or the employee at the park. In addition this
 *         department also receives from the server the confirmation of the
 *         details and returns messages to the user accordingly
 */
public class Login extends AbstractController {

	private static ActionEvent event;

	public static void LogOut(String Id) {
		Message sendMessage = new Message(Operation.Logout, Id);
		DataManager.getDataManager().clearAll();
		SendToServer(sendMessage);
	}

	@SuppressWarnings("unused")
	public static void receivedLogOut(Message msg) {
		String Id = (String) msg.getObj();
	}

	/**
	 * @param username
	 * @param password
	 * @param BtnEvent The function receives the login details from the user and
	 *                 sends them to the server for testing
	 */
	public static void requestLogin(String username, String password, ActionEvent BtnEvent) {
		ArrayList<String> login = new ArrayList<String>();
		login.add(username);
		login.add(password);
		event = BtnEvent;
		Message sendMessage = new Message(Operation.Login, login);
		SendToServer(sendMessage);
	}


	/**
	 * @param msg this function receive massage from the server and display it to
	 *            the user
	 */
	public static void receiveLogin(Object msg) {
		Message receivedMessage = (Message) msg;
		if(receivedMessage.getPermission()==Permission.NULL) {
			LoginCemsController.loginCemsController.setError("The user does not exist");
			return;
		}
		if (receivedMessage.getObj() instanceof Teacher) {
			Teacher teacher=(Teacher)receivedMessage.getObj();
			switch (receivedMessage.getPermission()) {
			case yes:
				dataManager.setCurrentUser(teacher);
				dataManager.setPreOrder(false);
				LoginCemsController.setTeacherLogin(teacher, event);
				break;
			case no:
				//EmployeeLoginController.EmployeeLoginController.setError("Wrong User Name or Password");
				LoginCemsController.loginCemsController.setError("Wrong User Name or Password");
				break;

			case AlreadyLoggedIn:
				//EmployeeLoginController.EmployeeLoginController.setError("The user already logged in");
				LoginCemsController.loginCemsController.setError("The user already logged in");
				break;

			default:
				break;
			}
		}
		if (receivedMessage.getObj() instanceof Student) {
			Student student=(Student)receivedMessage.getObj();
			switch (receivedMessage.getPermission()) {
			case yes:
				dataManager.setCurrentUser(student);
				dataManager.setPreOrder(false);
				LoginCemsController.setStudentLogin(student, event);
				break;
			case no:
				//EmployeeLoginController.EmployeeLoginController.setError("Wrong User Name or Password");
				LoginCemsController.loginCemsController.setError("Wrong User Name or Password");
				break;

			case AlreadyLoggedIn:
				//EmployeeLoginController.EmployeeLoginController.setError("The user already logged in");
				LoginCemsController.loginCemsController.setError("The user already logged in");
				break;

			default:
				break;
			}
		}
		if (receivedMessage.getObj() instanceof Principal) {
			Principal principal=(Principal)receivedMessage.getObj();
			switch (receivedMessage.getPermission()) {
			case yes:
				dataManager.setCurrentUser(principal);
				dataManager.setPreOrder(false);
				LoginCemsController.setPrincipalLogin(principal, event);
				break;
			case no:
				//EmployeeLoginController.EmployeeLoginController.setError("Wrong User Name or Password");
				LoginCemsController.loginCemsController.setError("Wrong User Name or Password");
				break;

			case AlreadyLoggedIn:
				//EmployeeLoginController.EmployeeLoginController.setError("The user already logged in");
				LoginCemsController.loginCemsController.setError("The user already logged in");
				break;

			default:
				break;
			}
		}
	}

//	public static void resiveSubLogin(Object msg) {
//		Message resivedMessage = (Message) msg;
//		switch (resivedMessage.getPermesion()) {
//		case yes:
//			Visitor visitor = (Visitor) resivedMessage.getObj();
//			dataManager.setCurrentUser(visitor);
//			dataManager.setPreOrder(true);
//			String name = visitor.getFirstName() + " " + visitor.getLastName();
//			TravelerLoginController.TravelerLoginController.setVisitorLogin(name, event);
//			break;
//		case NULL:
//			TravelerLoginController.TravelerLoginController.setError("The subscriber does not exist");
//			break;
//		case AlreadyLoggedIn:
//			TravelerLoginController.TravelerLoginController.setError("The user already logged in");
//			break;
//		default:
//			break;
//		}
//	}

//	public static void resiveVisitorLogin(Object msg) {
//		Message resivedMessage = (Message) msg;
//		if (resivedMessage.getPermesion() == Permission.AlreadyLoggedIn) {
//			TravelerLoginController.TravelerLoginController.setError("The user already logged in");
//		} else {
//			Visitor visitor = (Visitor) resivedMessage.getObj();
//			dataManager.setCurrentUser(visitor);
//			dataManager.setPreOrder(true);
//			String name;
//			if (visitor.getFirstName() != null && visitor.getLastName() != null)
//				name = visitor.getFirstName() + " " + visitor.getLastName();
//			else
//				name = "Guest";
//			TravelerLoginController.TravelerLoginController.setVisitorLogin(name, event);
//		}
//	}

}
