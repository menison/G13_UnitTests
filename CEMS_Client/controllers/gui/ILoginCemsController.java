package gui;

import cachedUserData.DataManager;
import entities.Teacher;
import javafx.event.ActionEvent;

public interface ILoginCemsController {
	
	public static void setTeacherLogin(Teacher teacher,ActionEvent event) {
		DataManager dm = DataManager.getDataManager();
		dm.setCurrentUser(teacher);
	}
	public void setError(String msg);
}
