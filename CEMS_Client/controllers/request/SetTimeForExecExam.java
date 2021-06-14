package request;


import cachedUserData.DataManager;
import entities.Message;

public class SetTimeForExecExam {
	
	/**
	 * This method sets tart time for an exam that is currently meant to be executed, 
	 * this will be used to check if the student entered the exam in a valid time
	 * @param msg
	 */
	public static void setTime(Message msg) {
		String timeToSet = (String)msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.getTestInExecution().setsTime(timeToSet);
	}
}
