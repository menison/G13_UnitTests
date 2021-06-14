package request;
import cachedUserData.DataManager;
import entities.Message;
import entities.Question;

/**Class QuestionInfoHandler
 * @author David
 * 
 * This class is used to communicate with data manager regarding questionInfo
 * used when user edits questions
 */
public class QuestionInfoHandler {
	
	
/**
 * @param msg 			comes from server holds Question ojbect
 * 
 * this method is for adding questionInfo which comes in a Question object from server
 * to the Data Manager
 */
public static void addToDB(Message msg) {
			Question quest = (Question)msg.getObj();
			
			DataManager.getDataManager().setQuestion(quest);
			
		}

/**
 * @param msg			String that comes from server as message
 * 
 */
public static void getMsg(Message msg) {
	String str = (String)msg.getObj();
	
	DataManager.getDataManager().setActivateMsg(str);
	
	}

}



