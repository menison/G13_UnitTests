package dataParsing;

import java.io.File;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.Connection;
import common.Operation;
import database.Query;
import database.SetConnectionDB;
import entities.ExecutedTest;
import entities.Message;
import server.EchoServer;

public class ManualTestUploader {
	public static Message uploadManualTest(Object obj) {
		Message msg = (Message)obj;
		Object[] arr = (Object[]) msg.getObj();
		File f = (File) arr[0];
		ExecutedTest t = (ExecutedTest) arr[1];
		
		try {
			byte[] fileContent = Files.readAllBytes(f.toPath());
			Connection c = SetConnectionDB.start();
			Blob b = c.createBlob();
			b.setBytes(1,fileContent);
			Query.writeManualTestBlobToDB(b, t);
		} catch (Exception e) {
			e.printStackTrace();
			return new Message(Operation.UploadManualTest, "fail");
		}
		EchoServer.SC.addToTextArea("Test downloaded successfully. You can find it in:" 
				+ f.getAbsolutePath() + "\n");
		return new Message(Operation.UploadManualTest, "success");
	}
}
