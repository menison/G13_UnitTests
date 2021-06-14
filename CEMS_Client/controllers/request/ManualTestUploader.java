package request;

import entities.Message;

public class ManualTestUploader {

	public static void checkUploadStatus(Message receivedMessage) {
		System.out.println("Hey");
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
