package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.Message;
import entities.TestForTable;

public class StudentTestTable {
	
	public static void setTable(Message msg) {
		ArrayList<TestForTable> t = (ArrayList<TestForTable>)msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setExecutedExams(t);
	}
}
