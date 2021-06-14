package request;

import java.util.ArrayList;
import java.util.HashMap;
import cachedUserData.DataManager;
import entities.Message;
import entities.Report;

/**
 * @author David
 *PrincipalSetReport handler
 */
@SuppressWarnings("unchecked")

public class PrincipalSetReport {
	/**
	 * @param msg
	 * generates report for principal
	 */
	public static void generateReport(Message msg) {
		HashMap<Integer, Integer> gradesAndAppearance = new HashMap<Integer, Integer>();
		int grade;
		float sum=0;
		ArrayList<String> returnedValues = (ArrayList<String>) msg.getObj();
		Report report = new Report(returnedValues.get(0), returnedValues.get(1));
		returnedValues.remove(0);
		returnedValues.remove(0);
		ArrayList<Integer> grades = new ArrayList<Integer>();
		for (String str : returnedValues) {
			grade = Integer.parseInt(str);
			sum+=grade;
			grades.add(grade);
			if (!gradesAndAppearance.containsKey(grade)) {
				gradesAndAppearance.put(grade, 1);
			} else {
				gradesAndAppearance.put(grade, gradesAndAppearance.get(grade) + 1);
			}
		}
		report.setGradesAndAppearance(gradesAndAppearance);
		grades.sort(null);
		report.setMedian(grades.get(grades.size()/2));
		report.setAverageScore(sum/(grades.size()));
		DataManager.getDataManager().setReport(report);
	}
}
