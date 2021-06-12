package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.Message;
import entities.TestForTable;


public class TeacherSetTableForSelfTests {
	public static void setTableForSelfTests(Message msg) {
		String executedExams = (String) msg.getObj();
		ArrayList<TestForTable> testList = new ArrayList<TestForTable>();
		for(String str:executedExams.split(";")){
			TestForTable test = new TestForTable(str);
			testList.add(test);
		}
		DataManager.getDataManager().setExecutedExams(testList);
	}
}
