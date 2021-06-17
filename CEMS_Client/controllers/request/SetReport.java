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

public class SetReport {
	private static Report report;
	public SetReport(Report report) {//Constructor for tests
		super();
		SetReport.report = report;
	}
	
	public SetReport() {//Constructor for production
		super();
		SetReport.report = new Report();
	}
	/**
	 * @param msg
	 * generates report for principal
	 */
	public static void generateReport(Message msg) {
		HashMap<Integer, Integer> gradesAndAppearance = new HashMap<Integer, Integer>();
		int grade;
		float sum=0;
		float sumOfTests=0;
		float val=0;
		ArrayList<String> returnedValues = (ArrayList<String>) msg.getObj();
		report.setGegeneratedBy(returnedValues.get(0));
		report.setValue(returnedValues.get(1));
		returnedValues.remove(0);
		returnedValues.remove(0);
		ArrayList<Integer> grades = new ArrayList<Integer>();
		for (String str : returnedValues) {
			grade = Integer.parseInt(str);
			grades.add(grade);
			if (!gradesAndAppearance.containsKey(grade)) {
				gradesAndAppearance.put(grade, 1);
			} else {
				gradesAndAppearance.put(grade, gradesAndAppearance.get(grade) + 1);
			}
		}
		for (Integer key : gradesAndAppearance.keySet()) {
			val = gradesAndAppearance.get(key);
			sum += (key*val);
			sumOfTests += val;
		}
		report.setGradesAndAppearance(gradesAndAppearance);
		grades.sort(null);
		report.setMedian(grades.get(grades.size()/2));
		report.setAverageScore(sum/sumOfTests);
		DataManager.getDataManager().setReport(report);
	}
}
