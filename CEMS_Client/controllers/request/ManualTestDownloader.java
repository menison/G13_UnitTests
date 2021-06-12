package request;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import entities.Message;

public class ManualTestDownloader {

	public static void simulateManualTestExecution(Message receivedMessage) {
		File f = (File) receivedMessage.getObj();
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write("Student has answered the manual test, there it is.");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
