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
		
		test=Query.SelectTableWhere("test", "testiD", testID);
		try {
			test.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(test.getInt(8)==1)	
				return new Message(Operation.ActivateTestCode,"Test already activate");
			else{
				codes=Query.SelectTableWhere("execodehistory", "code", pinCode);
				if(codes.next()) {
					return new Message(Operation.ActivateTestCode,"code is already used");
				}else {
					//Query.updateByCondition(String table,String column, String value, String condition);
					System.out.println(pinCode);
					System.out.println(testID);
					System.out.println(date);
					System.out.println(time);
					System.out.println(userID);
					Query.update("UPDATE test SET activatedBy = '"+userID+"' WHERE testID = '"+testID+"';");
					Query.update("UPDATE test SET DateOfStart = '"+date+"' WHERE testID = '"+testID+"';");
					Query.update("UPDATE test SET timeOfStart = '"+time+"' WHERE testID = '"+testID+"';");
					Query.update("UPDATE test SET currExecCode = '"+pinCode+"' WHERE testID = '"+testID+"';");

					}

				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return new Message(Operation.ActivateTestCode,"code is already used");
		
		

		
		
	}
}






