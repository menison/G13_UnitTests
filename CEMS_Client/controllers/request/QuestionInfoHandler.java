package request;
import cachedUserData.DataManager;
import entities.Message;
import entities.Question;

public class QuestionInfoHandler {
	
public static void addToDB(Message msg) {
			Question quest = (Question)msg.getObj();
			
			DataManager.getDataManager().setQuestion(quest);
			
		}

public static void getMsg(Message msg) {
	String str = (String)msg.getObj();
	
	DataManager.getDataManager().setActivateMsg(str);
	
	}

}



