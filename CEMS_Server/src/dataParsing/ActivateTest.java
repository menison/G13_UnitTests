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
		ResultSet test;
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
					if(codes.next()) {
						System.out.println("failed");
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

						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return new Message(Operation.ActivateTestCodeFailed,"Activate failed");
				}
				
				System.out.println("hi");
		return new Message(Operation.ActivateTestCodeSuccess,"Activated Successfully");
		
		

		
		
	}
}






