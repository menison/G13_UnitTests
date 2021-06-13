package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.ActivatedTest;
import entities.Message;
import entities.TestForFullTable;
import gui.ServerController;


public class ActivateTest {
	
	public static Message validateAndActivate(Message msg){
		ResultSet codes;
		ResultSet testForDuration;

		//String[] pinAndTestID=(String[])msg.getObj();
		ActivatedTest test =(ActivatedTest)msg.getObj();
				int duration = 0;
				testForDuration = Query.SelectTableWhere("test", "testID", test.getTestID());
				try {
					testForDuration.next();
					duration = testForDuration.getInt(3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				codes=Query.SelectTableWhere("activatedtest", "code", test.getTestCode());

				try {
					ServerController.sc.addToTextArea("checking code");
					if(codes.next()) {
						return new Message(Operation.ActivateTestCodeFailed,"code is already in use, please choose another");

					}else {
						
						
						Query.update("INSERT INTO `query`.`activatedtest` (`code`, `testID`, `activatedBy`, `startDate`, `startTime`, `isActive`, duration) "
								+ "VALUES ('"+test.getTestCode()+"', '"+test.getTestID()+"', '"+test.getActivatedBy()+"', '"+test.getStartDateToString()+"', '"+test.getStartTimeToString()+"', 1,"+duration+");");
						ServerController.sc.addToTextArea("test ID:"+test.getTestID()+" was activated with code:"+test.getTestCode());
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return new Message(Operation.ActivateTestCodeFailed,"Activate failed");
				}
				
		return new Message(Operation.ActivateTestCodeSuccess,"Activated Successfully");

		
	}
}






