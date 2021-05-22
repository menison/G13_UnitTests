package dataParsing;

import entities.Message;

public class Parsing {
	/**
	 * @param This class receives all types of messages resulting from clicks in the
	 *             system and routes them to the appropriate action for each of
	 *             them.
	 */
	public static void Message(Message receivedMessage) {

		
		switch (receivedMessage.getOperationType()) {
		
		case Operation1:
			
			break;

		default:
			break;
		}
		
	}
	
	
}