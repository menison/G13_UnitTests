package logics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import common.Operation;
import database.Query;
import entities.Message;
import entities.TestToConfirm;

public class FraudChecker {
	
	public static Message checkFraud(Message receivedMessage) {
		ArrayList<Suspect> potentionalCriminals = new ArrayList<>();
		HashSet <String> guiltyStudents = new HashSet<>();
		TestToConfirm t = (TestToConfirm) receivedMessage.getObj();
		String testCode = t.getTestCode();
		ResultSet rs = Query.getAllExecutedTestsByCode(testCode);
		
		try {
			while (rs.next()) {
				String student = rs.getString(3);
				String answers = rs.getString(10);
				Suspect s = new Suspect(student, answers);
				potentionalCriminals.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i=0; i < potentionalCriminals.size(); i++) {
			for (int j=1; j<potentionalCriminals.size(); j++) {
				if (isCouplesGuilty(potentionalCriminals.get(i), potentionalCriminals.get(j))){
					guiltyStudents.add(potentionalCriminals.get(i).getStudentID());
					guiltyStudents.add(potentionalCriminals.get(j).getStudentID());
				}	
			}
		}
		for (int i=0; i<guiltyStudents.size();i++) {
			Query.updateIsSuspect(testCode, (String)(guiltyStudents.toArray())[i]);
		}
		return new Message(Operation.CheckFraud, guiltyStudents);
	}
	
	private static boolean isCouplesGuilty(Suspect s1, Suspect s2) {
		
		int[] answers1 = s1.getIntAnswers();
		int[] answers2 = s2.getIntAnswers();
//		int counter = 0;
//		int loopSize = answers1.length;
		
		if (Arrays.equals(answers1, answers2)) 
			return true;
		return false;
		
//		for (int i=0; i<loopSize; i++)
//			if (answers1[i] == answers2[i])
//				counter++;
//		
//		if (counter == loopSize)
//			return true;
//		return false;
	}

	
	public static class Suspect{
		String studentID;
		int[] intAnswers;
		
		public Suspect(String studentID, String answers) {
			this.studentID = studentID;
			String[] splitted = answers.split(",");
			intAnswers = new int[splitted.length];
			for (int i=0; i<splitted.length; i++)
				intAnswers[i] = Integer.parseInt(splitted[i]);
		}

		public String getStudentID() {
			return studentID;
		}

		public int[] getIntAnswers() {
			return intAnswers;
		}
	}
}
