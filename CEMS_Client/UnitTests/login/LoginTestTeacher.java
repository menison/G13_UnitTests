package login;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.ClientController;
import application.ClientUI;
import application.IClientController;
import common.Operation;
import entities.Message;
import entities.Teacher;
import gui.ILoginCemsController;
import javafx.event.ActionEvent;
import request.Login;

class LoginTestTeacher {

	private Message msg;
	private String errorMsg;
	ILoginCemsController ilcc;
	Login login;
	private Teacher teacher;
	private ActionEvent buttonEvent;
	

	public class StubClientController extends ClientController implements IClientController {

		public StubClientController(String host, int port) {
			super(host, port);
		}

		@Override
		public void accept(Message message) {
			msg = message;
		}

	}

	public class StubLoginCemsController implements ILoginCemsController {

		@Override
		public void setError(String msg) {
			errorMsg = msg;

		}

	}

	@BeforeEach
	void setUp() throws Exception {
		ClientUI.chat = new StubClientController("Stub", 5555);
		ilcc = new StubLoginCemsController();
		login = new Login(ilcc);
		teacher = new Teacher("Ilya", "123", "Ilya", "Zeldner", "112233", "a@a.com", "Teacher");
		buttonEvent = new ActionEvent();
	}
	
	@Test
	void testTeacherLoginSuccess() {
		ArrayList<String> arrayToSend = new ArrayList<String>();
		Operation expectedOp = Operation.Login;
		arrayToSend.add(teacher.getUsername());
		arrayToSend.add(teacher.getPassword());
		msg = new Message(Operation.Login,arrayToSend);
		login.requestLogin(teacher.getUsername(), teacher.getPassword(), buttonEvent);
		
	}

	@Test
	void testTeacherLoginFailure_alreadyLogged() {

	}

	@Test
	void testTeacherLoginFailure_wrongCredentials() {

	}

	@Test
	void testStudentLoginSuccess() {

	}

	@Test
	void testStudentLoginFailure_alreadyLogged() {

	}

	@Test
	void testStudentLoginFailure_wrongCredentials() {

	}

	@Test
	void testPrincipalLoginSuccess() {

	}

	@Test
	void testPrincipalLoginFailure_alreadyLogged() {

	}

	@Test
	void testPrincipalLoginFailure_wrongCredentials() {

	}
}
