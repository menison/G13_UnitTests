package request;

import entities.Message;

public class ManualTestUploader {

	/**
	 * This method updates if the manual test has been uploaded successfully
	 * @param receivedMessage
	 */
	public static void checkUploadStatus(Message receivedMessage) {
		String status = (String) receivedMessage.getObj();
		switch (status) {
		case "fail":
			System.out.println("Failed writing manual test to DB");
			break;
		case "success":
			System.out.println("Succeeded writing manual test to DB");
			break;
		}
		
	}

}
