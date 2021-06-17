package login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.ClientController;
import application.ClientUI;
import application.IClientController;
import entities.Message;
import gui.ILoginCemsController;

class LoginTestTeacher {

	private Message msg;
	private String errorMsg;
	ILoginCemsController ilcc;
	

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
	}

	@Test
	void testTeacherLoginSuccess() {

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
