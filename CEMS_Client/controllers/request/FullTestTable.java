package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.Message;
import entities.TestForFullTable;

public class FullTestTable {
	
	public static void setTable(Message msg) {
		String str = msg.getObj().toString();
		ArrayList<TestForFullTable> testList = new ArrayList<>();
		String[] tuples = str.split("/");
		String[] fields;
		for(int i = 0; i < tuples.length; i++) {
			fields = tuples[i].split(",");
			TestForFullTable t = new TestForFullTable(fields[0],fields[1],fields[2],
					Integer.parseInt(fields[3]),fields[4]);
			testList.add(t);
		}
		DataManager dm = DataManager.getDataManager();
		dm.setFullTable(testList);
	}

}
