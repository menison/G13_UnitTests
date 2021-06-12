package dataParsing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import entities.Message;
import entities.Test;

public class ManualTestUploader {
	public Message uploadManualTest(Object obj) {
		Object[] arr = new Object[2];
		arr = (Object[]) obj;
		File f = (File) arr[0];
		Test t = (Test) arr[1];
		String desiredPathToSave = f.getAbsolutePath();
		File manualTest = new File(desiredPathToSave);
		
		try {
			if (manualTest.createNewFile()) {
			    System.out.println("File created: " + manualTest.getName());
			  } else {
			    System.out.println("File already exists.");
			  }
			FileWriter myWriter = new FileWriter(manualTest);
	
			myWriter.write("manual test to execute - testID:"+ t.getTestID() +
					", executionCode:"+ t.getCurrExecutionCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
