package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.Message;
import entities.TestForTable;

public class StudentTestTable {
	
	public static void setTable(Message msg) {
		String str = msg.getObj().toString();
		DataManager dm = DataManager.getDataManager();
		ArrayList<TestForTable> testList = new ArrayList<>();
		String[] tuples = str.split("/");
		String[] fields;
		if(str == "") {
			dm.setExecutedExams(null);
			return;
		}
		for(int i = 0; i < tuples.length; i++) {
			fields = tuples[i].split(",");
			TestForTable t = new TestForTable(fields[0],fields[1],fields[2],
					Integer.parseInt(fields[3]),Integer.parseInt(fields[4]),
					Integer.parseInt(fields[5]));
			testList.add(t);
		}
		dm.setExecutedExams(testList);
	}
}
