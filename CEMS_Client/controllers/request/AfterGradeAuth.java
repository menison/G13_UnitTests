package request;

import entities.Message;

public class AfterGradeAuth {

	public static void notifyUser(Message receivedMessage) {
		String res = (String) receivedMessage.getObj();
		switch (res) {
		case "success":
			System.out.println("HeyFromSuccess");
			break;
		case "failure":
			System.out.println("HeyFromFailure");
			break;
		}
	}
}
