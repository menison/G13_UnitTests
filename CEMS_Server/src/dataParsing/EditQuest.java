package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;
import entities.Question;

/**Class EditQuest handles requests for editing questions
 * @author David
 *
 */
public class EditQuest {
	/**
	 * @param msg			message contains String with questionID
	 * @param questID		holds questionID from message msg
	 * @param rs			ResultSet holds question with given ID
	 * @return				returns message with question if succeeded			
	 * this method gets info bout a question from the SQL server given a question ID
	 */
	public static Message getInfo(Message msg){
		String questID = (String)msg.getObj();
		ResultSet rs;
		rs=Query.getReport("SELECT * FROM query.question where questionID = "+questID);
		Question quest;
		try {
			if(rs.next()) {
				rs.getString(4);
				String[] answers = rs.getString(3).split(",");
				quest = new Question(rs.getString(1),rs.getString(2),answers,rs.getInt(4),rs.getString(5));
				return new Message(Operation.GetQuestionInfo,quest);
			}else {
				return new Message(Operation.GetQuestionInfo,null);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	
		
		return new Message(Operation.GetQuestionInfo,null);
		
	}
	
	/**
	 * @param msg			msg contains Question object from client	
	 * @return				returns feedback message of success
	 * method to update a certaion question in database
	 */
	public static Message updateQuest(Message msg){
		Question quest = (Question)msg.getObj();
		Query.update("UPDATE question SET text = '"+ quest.getText()+"', answers = '"+quest.getAnswersString()+"', correctAnswerIndex = '"+quest.getCorrectAnswerIndex()+"', composedBy = '"+quest.getTeacherComposed()+"' WHERE questionID = '"+quest.getQuestionID()+"';");
		return new Message(Operation.SubmitQuestionInfo,"Question updated susccessfully");
		
		
		
	}
	
}
