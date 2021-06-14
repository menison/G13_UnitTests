package request;

import entities.Message;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.ActivatedTest;

/**Class AddTeacherTestsToDM
 * @author David
 * the class gets a received message as ArrayList and loads it to the data manager
 */
@SuppressWarnings("unchecked")
public class AddTeacherTestsToDM {
	public  static void add(Message msg) {
		ArrayList<ActivatedTest> activatedTestsByTeacher= (ArrayList<ActivatedTest>)msg.getObj();
	DataManager.getDataManager().setTeacherActivatedTests(activatedTestsByTeacher);	
	}
}
