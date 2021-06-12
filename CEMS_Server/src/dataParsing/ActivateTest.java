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
		Message messageToReturn;
		String[] pinAndTestID=(String[])msg.getObj();
		System.out.println(pinAndTestID[0]);
		System.out.println(pinAndTestID[1]);
		test=Query.SelectTableWhere("test", "testiD", pinAndTestID[1]);
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
				codes=Query.SelectTableWhere("execodehistory", "code", pinAndTestID[0]);
				if(codes.next()) {
					System.out.println("ossss");
					return new Message(Operation.ActivateTestCode,"code is already used");
				}else {
						System.out.println("ok");
					}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return new Message(Operation.ActivateTestCode,"code is already used");
		
		

		
		
	}
}






