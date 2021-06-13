package request;


import cachedUserData.DataManager;
import entities.Message;

public class SetTimeForExecExam {
	
	public static void setTime(Message msg) {
		String timeToSet = (String)msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.getTestInExecution().setsTime(timeToSet);
	}
}
