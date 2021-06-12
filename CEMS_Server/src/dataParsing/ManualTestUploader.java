package dataParsing;

import java.io.File;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;

import database.SetConnectionDB;
import entities.ExecutedTest;
import entities.Message;

public class ManualTestUploader {
	public static Message uploadManualTest(Object obj) {
		Object[] arr = new Object[2];
		arr = (Object[]) obj;
		File f = (File) arr[0];
		ExecutedTest t = (ExecutedTest) arr[1];
		
		try {
			byte[] fileContent = Files.readAllBytes(f.toPath());
			Connection c = SetConnectionDB.start();
			Blob b = c.createBlob();
			b.setBytes(1,fileContent);
			Query.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
