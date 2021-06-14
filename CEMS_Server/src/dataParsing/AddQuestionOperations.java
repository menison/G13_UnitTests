package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;


import common.Operation;
import database.Query;
import entities.Message;
import entities.Question;
import gui.ServerController;


/**Class for adding a question operation to the database.
 * @author Aviv
 *
 */
public class AddQuestionOperations {

	/**Method for returning the full amount of question in the database.
	 * @param msg Message containing the operation name.
	 * @return return a message containing a string of the amount of question.
	 */
	public static Message getAmountOfQuestions(Message msg) {
		Integer amountOfQuestions;
		ResultSet rs;
		Message messageToReturn;
		try {
			rs = Query.countTableEntries("question");
			ServerController.sc.addToTextArea("Counting Questions");
			rs.next();
			amountOfQuestions = rs.getInt(1);
			rs.close();
			messageToReturn = new Message(Operation.GetAmountOfQuestions, amountOfQuestions.toString());
			return messageToReturn;
		} catch (SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}
	/**Method for getting the amount of questions related to course.
	 * @param msg Message that contains the operation name.
	 * @return Return the message containing the operation name and the number of questions to the client.
	 */
	public static Message getAmountOfCourseQuestions(Message msg) {
		Integer amountOfQuestions;
		ResultSet rs;
		Message messageToReturn;
		try {
			rs=Query.SelectColumnTableWhere("numOfQuestions", "course", "ID", (String)msg.getObj());
			ServerController.sc.addToTextArea("Counting Questions For Course ID: "+(String)msg.getObj());
			rs.next();
			amountOfQuestions=rs.getInt(1);
			rs.close();
			messageToReturn=new Message(Operation.GetCourseAmountOfQuestions,amountOfQuestions);
			return messageToReturn;
		}catch(SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}
	/**Method for adding a question to the database after calculating the question id
	 * @param msg Message the operation name and a question entity.
	 * @return returns the message containing the operation and the successfull string message.
	 */
	public static Message addQuestionToDB(Message msg) {
		Question qst=(Question) msg.getObj();
		String fieldID=qst.getQuestionID();
		Message messageToReturn;
		
		Integer number = getAmountOfFieldQuestionsbyString(fieldID);
		
		String ID=Generate(fieldID,(int)number);
		
		qst.setQuestionID(ID);
		Query.InsertQuestionToDataBase(qst);
		Query.IncreaseNumOfQuestionInField(fieldID);
		ServerController.sc.addToTextArea("Added a question to the database with ID: "+qst.getQuestionID());
		messageToReturn=new Message(Operation.AddQuestionToDatabase,"Question has been added");
		return messageToReturn;
	}
	

	/**Get amount of questions in a specific field.
	 * @param msg containing the id of the field.
	 * @return returns amount of question in a field.
	 */
	public static int  getAmountOfFieldQuestionsbyString(String msg) {
		Integer amountOfQuestions;
		ResultSet rs;
		try {
			rs=Query.SelectColumnTableWhere("numOfQuestions", "field", "ID", msg);
			ServerController.sc.addToTextArea("Counting Questions For Course ID: "+msg);
			rs.next();
			amountOfQuestions=rs.getInt(1);
			rs.close();
			return amountOfQuestions;
		}catch(SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return 0;

}
	/**Method for generating question id number using the field id and the number of existing questions.
	 * @param fieldID field ID
	 * @param numOfExistingQuestions number of existing question in that field.
	 * @return returns a generated ID in string format.
	 */
	public static String Generate(String fieldID,int numOfExistingQuestions) {
		numOfExistingQuestions++;
		int qNum=numOfExistingQuestions;
		String generatedID="";
		String qNumString="";
		if(qNum<10) {
			qNumString="00"+Integer.toString(qNum);
		}
		else if(qNum<100) {
			qNumString="0"+Integer.toString(qNum);
		}
		else
			qNumString=Integer.toString(qNum);
		generatedID=fieldID+qNumString;
		return generatedID;
	}
}
