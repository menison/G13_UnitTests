package login;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.ClientController;
import application.ClientUI;
import application.IClientController;
import common.Operation;
import entities.Message;
import entities.Student;
import entities.Teacher;
import gui.ILoginCemsController;
import javafx.event.ActionEvent;
import request.Login;

class LoginTest {

	private Message msg;
	private String errorMsg;
	ILoginCemsController ilcc;
	Login login;
	private Teacher teacher;
	private Student student;
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
		student = new Student("")
		buttonEvent = new ActionEvent();
	}

	@Test
	void testTeacherLoginSuccess() {
		// Initialize
		ArrayList<String> arrayToSend = new ArrayList<String>();
		Operation expectedOp = Operation.Login;
		arrayToSend.add(teacher.getUsername());
		arrayToSend.add(teacher.getPassword());
		msg = new Message(Operation.Login, arrayToSend);

		// Act
		login.requestLogin(teacher.getUsername(), teacher.getPassword(), buttonEvent);
		ArrayList<String> incomingData = (ArrayList<String>) msg.getObj();

		// Assert
		assertEquals(Login.event, buttonEvent);
		assertEquals(expectedOp, msg.getOperation());
		assertEquals(teacher.getUsername(), incomingData.get(0));
		assertEquals(teacher.getPassword(), incomingData.get(1));

	}

//	@Test
//	void testTeacherLoginFailure_alreadyLogged() {
//
//	}
//
//	@Test
//	void testTeacherLoginFailure_wrongCredentials() {
//
//	}
//
	@Test
	void testStudentLoginSuccess() {
		ArrayList<String> arrayToSend = new ArrayList<String>();
		Operation expectedOp = Operation.Login;
		arrayToSend.add(teacher.getUsername());
		arrayToSend.add(teacher.getPassword());
		msg = new Message(Operation.Login, arrayToSend);

		// Act
		login.requestLogin(teacher.getUsername(), teacher.getPassword(), buttonEvent);
		ArrayList<String> incomingData = (ArrayList<String>) msg.getObj();

		// Assert
		assertEquals(Login.event, buttonEvent);
		assertEquals(expectedOp, msg.getOperation());
		assertEquals(teacher.getUsername(), incomingData.get(0));
		assertEquals(teacher.getPassword(), incomingData.get(1));
	}

//	@Test
//	void testStudentLoginFailure_alreadyLogged() {
//
//	}
//
//	@Test
//	void testStudentLoginFailure_wrongCredentials() {
//
//	}
//
//	@Test
//	void testPrincipalLoginSuccess() {
//
//	}
//
//	@Test
//	void testPrincipalLoginFailure_alreadyLogged() {
//
//	}
//
//	@Test
//	void testPrincipalLoginFailure_wrongCredentials() {
//
//	}
}
