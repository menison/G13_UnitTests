package request;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cachedUserData.DataManager;
import entities.Message;
import entities.Test;

public class ManualTestDownloader {
	public Message downloadManualTest(Object obj) {
		DataManager dm = DataManager.getDataManager();
		Test t = dm.getTestInExecution().getTest();
		File f = (File)obj;
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
