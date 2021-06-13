package request;

import entities.Message;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.ActivatedTest;

@SuppressWarnings("unchecked")
public class AddTeacherTestsToDM {
	public  static void add(Message msg) {
		ArrayList<ActivatedTest> activatedTestsByTeacher= (ArrayList<ActivatedTest>)msg.getObj();
	DataManager.getDataManager().setTeacherActivatedTests(activatedTestsByTeacher);	
	}
}
