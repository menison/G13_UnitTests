package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;
import entities.TestForFullTable;
import gui.ServerController;

public class ActivateTest {

	public static Message validateAndActivate(Message msg){
		ResultSet codes;
		String pinCode;
		String testID;
		String date;
		String time;
		String userID;
		
		String[] pinAndTestID=(String[])msg.getObj();
		pinCode=pinAndTestID[0];
		testID=pinAndTestID[1];
		date=pinAndTestID[2];
		time=pinAndTestID[3];
		userID=pinAndTestID[4];
		
				codes=Query.SelectTableWhere("activatedtest", "code", pinCode);
				try {
					ServerController.sc.addToTextArea("checking code");
					if(codes.next()) {
						return new Message(Operation.ActivateTestCodeFailed,"code is already in use, please choose another");
					
					}else {
						//Query.updateByCondition(String table,String column, String value, String condition);
//						System.out.println(pinCode);
//						System.out.println(testID);
//						System.out.println(date);
//						System.out.println(time);
//						System.out.println(userID);
						Query.update("INSERT INTO `query`.`activatedtest` (`code`, `testID`, `activatedBy`, `startDate`, `startTime`, `isActive`) "
								+ "VALUES ('"+pinCode+"', '"+testID+"', '"+userID+"', '"+date+"', '"+time+"', '1');");
						ServerController.sc.addToTextArea("test ID:"+testID+" was activated with code:"+pinCode);
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return new Message(Operation.ActivateTestCodeFailed,"Activate failed");
				}
				
		return new Message(Operation.ActivateTestCodeSuccess,"Activated Successfully");
		
		

		
		
	}
}






