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

		//String[] pinAndTestID=(String[])msg.getObj();
		ActivatedTest test =(ActivatedTest)msg.getObj();

		
				codes=Query.SelectTableWhere("activatedtest", "code", test.getTestCode());
				try {
					ServerController.sc.addToTextArea("checking code");
					if(codes.next()) {
						return new Message(Operation.ActivateTestCodeFailed,"code is already in use, please choose another");
					
					}else {

						Query.update("INSERT INTO `query`.`activatedtest` (`code`, `testID`, `activatedBy`, `startDate`, `startTime`, `isActive`) "
								+ "VALUES ('"+test.getTestCode()+"', '"+test.getTestID()+"', '"+test.getActivatedBy()+"', '"+test.getStartDate()+"', '"+test.getStartTime()+"', '1');");
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






