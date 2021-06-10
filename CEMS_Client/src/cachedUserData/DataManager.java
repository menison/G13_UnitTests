package cachedUserData;

import java.util.ArrayList;

import entities.ExecutedTest;
import entities.Test;
import entities.TestForFullTable;
import entities.TestForTable;
import entities.User;

/**
 * @author avivs100
 *	Singleton whose job it is to know and hold the 
 *details of the current user of the system
 */
public class DataManager {
	private static DataManager instance = null;

	private ExecutedTest testInExecution;
	private User currentUser;
	private boolean PreOrder;
	private double GlobalPrice;
	private ArrayList<TestForTable> executedExams;
	private ArrayList<TestForFullTable> fullTestList;
	
	private DataManager() {
		this.currentUser = null;
		this.PreOrder = false;
		this.setGlobalPrice(10);
	}
	
	/**
	 * @return instance of data manager if exist or make on if its the first call and then return him 
	 */
	public static DataManager getDataManager() {
		if(instance == null) 
			instance = new DataManager();
		return instance;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public boolean isPreOrder() {
		return PreOrder;
	}

	public void setPreOrder(boolean preOrder) {
		this.PreOrder = preOrder;
	}

	public double getGlobalPrice() {
		return GlobalPrice;
	}

	public void setGlobalPrice(double globalPrice) {
		GlobalPrice = globalPrice;
	}
	
	public void clearAll() {
		this.currentUser = null;
		this.PreOrder = false;
	}
	
	public ExecutedTest getTestInExecution() {
		return testInExecution;
	}
	
	public void setExecutedExams(ArrayList<TestForTable> testList) {
		this.executedExams = testList;
	}
	
	public ArrayList<TestForTable> getExecutedExams() {
		return executedExams;
	}

	public void setTestInExecution(ExecutedTest testInExecution) {
		this.testInExecution = testInExecution;
	}
	public void setFullTable(ArrayList<TestForFullTable> testList) {
		this.fullTestList = testList;
	}
	public ArrayList<TestForFullTable> getFullTable() {
		return this.fullTestList;
	}
	
}
