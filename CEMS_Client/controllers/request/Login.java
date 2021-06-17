package request;

import java.util.ArrayList;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import common.Permission;
import entities.Message;
import entities.Principal;
import entities.Student;
import entities.Teacher;
import gui.ILoginCemsController;
import gui.LoginCemsController;
import gui.MyLoginCemsController;
import javafx.event.ActionEvent;


/**Class for requesting and receiving login operations from the server.
 * @author Aviv
 *
 */

public class Login extends AbstractController {


	/**
	 * transfer the action event from a pressed button
	 */
	private static ActionEvent event;
	private static LoginCemsController lcc;
	private static ILoginCemsController ilcc;


	/**Method for sending Logout message to the server
	 * @param Id current user ID
	 */
	public static void LogOut(String Id) {
		Message sendMessage = new Message(Operation.Logout, Id);
		DataManager.getDataManager().clearAll();
		SendToServer(sendMessage);
	}

		public Login() {
			ilcc = new MyLoginCemsController();
		}
		
		public Login(ILoginCemsController lcc) {
			Login.ilcc = lcc;
		}
		
		
	/**Method that receives a message from the server after sending the logout message
	 * @param msg received from the server
	 */
	@SuppressWarnings("unused")
	public static void receivedLogOut(Message msg) {
		String Id = (String) msg.getObj();
	}


	/**Method that sends login message to the server with the appropriate details
	 * @param username user's user name
	 * @param password user's password
	 * @param BtnEvent event of login button pressed
	 */
	public static void requestLogin(String username, String password, ActionEvent BtnEvent) {
		ArrayList<String> login = new ArrayList<String>();
		login.add(username);
		login.add(password);
		event = BtnEvent;
		Message sendMessage = new Message(Operation.Login, login);
		SendToServer(sendMessage);
	}



	/**Method for receiving login information from the server about the current user trying to log-in
	 * @param msg contains the permission which used to allow\deny the user to log-in into the system
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
				lcc.setTeacherLogin(teacher, event);
				break;
			case no:
				LoginCemsController.loginCemsController.setError("Wrong User Name or Password");
				break;

			case AlreadyLoggedIn:
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
				LoginCemsController.setStudentLogin(student, event);
				break;
			case no:
				LoginCemsController.loginCemsController.setError("Wrong User Name or Password");
				break;

			case AlreadyLoggedIn:
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
				LoginCemsController.setPrincipalLogin(principal, event);
				break;
			case no:
				LoginCemsController.loginCemsController.setError("Wrong User Name or Password");
				break;

			case AlreadyLoggedIn:
				LoginCemsController.loginCemsController.setError("The user already logged in");
				break;

			default:
				break;
			}
		}
	}



}
