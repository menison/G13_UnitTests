package request;

import entities.Message;

public class AfterGradeAuth {

	/**
	 * This method receives a message letting the user know if the grade confirmation has been
	 * performed successfully or failed 
	 * @param receivedMessage
	 */
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
