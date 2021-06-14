package entities;

import java.util.HashMap;

/**
 * @author David
 * used to create report from data base
 */
public class Report {
	private String gegeneratedBy;
	private String value;
	private HashMap<Integer, Integer> gradesAndAppearance;
	private int median;
	private float averageScore;

	/**
	 * @param gegeneratedBy			name of user who generated the report
	 * @param value					value
	 */
	public Report(String gegeneratedBy, String value) {
		super();
		this.gegeneratedBy = gegeneratedBy;
		this.value = value;
	}

	public String getGegeneratedBy() {
		return gegeneratedBy;
	}

	public void setGegeneratedBy(String gegeneratedBy) {
		this.gegeneratedBy = gegeneratedBy;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public HashMap<Integer, Integer> getGradesAndAppearance() {
		return gradesAndAppearance;
	}

	public void setGradesAndAppearance(HashMap<Integer, Integer> gradesAndAppearance) {
		this.gradesAndAppearance = gradesAndAppearance;
	}

	public int getMedian() {
		return median;
	}

	public void setMedian(int median) {
		this.median = median;
	}

	public float getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}
}
